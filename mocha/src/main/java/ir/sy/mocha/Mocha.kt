@file:Suppress("UNCHECKED_CAST")

package ir.sy.mocha

import android.content.Context
import ir.sy.mocha.mocker.annotations.MockFloat
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.data_creators.createBoolean
import ir.sy.mocha.mocker.data_creators.createDouble
import ir.sy.mocha.mocker.data_creators.createFloat
import ir.sy.mocha.mocker.data_creators.createInt
import ir.sy.mocha.mocker.data_creators.createLong
import ir.sy.mocha.mocker.data_creators.createString
import ir.sy.mocha.mocker.isBoolean
import ir.sy.mocha.mocker.isDouble
import ir.sy.mocha.mocker.isFloat
import ir.sy.mocha.mocker.isInt
import ir.sy.mocha.mocker.isList
import ir.sy.mocha.mocker.isLong
import ir.sy.mocha.mocker.isString
import ir.sy.mocha.utils.Constants
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

class Mocha(private val context: Context) {
    inline fun <reified T> mock(clazz: KClass<*>? = null): T {
        val actualClass = clazz ?: T::class
        val constructor: KFunction<T> = getConstructor(actualClass)
        val args = constructor.parameters
            .map { parameter ->
                createData(
                    parameter.type,
                    parameter.name,
                    findMochaAnnotations(parameter.annotations)
                )
            }.toTypedArray()

        return constructor.call(*args)
    }

    fun createData(
        type: KType? = null,
        variableName: String? = null,
        annotation: Annotation? = null
    ): Any? {
        return when {
            type?.isInt() == true ->
                createInt(
                    variableName.toString(),
                    if (annotation == null) null else annotation as MockInt
                )

            type?.isString() == true -> createString(
                variableName = variableName.toString(),
                context = context,
                annotation = if (annotation == null) null else annotation as MockString
            )

            type?.isFloat() == true -> createFloat(
                variableName = variableName.toString(),
                annotation = if (annotation == null) null else annotation as MockFloat
            )

            type?.isLong() == true -> createLong(
                variableName = variableName.toString(),
                annotation = if (annotation == null) null else annotation as MockLong
            )

            type?.isBoolean() == true -> createBoolean()
            type?.isDouble() == true -> createDouble()
            type?.isList() == true -> List(2) { createData(type = type.arguments.first().type) }

            else -> mock(type?.jvmErasure)
        }
    }

    fun findMochaAnnotations(annotations: List<Annotation>): Annotation? {
        return annotations.firstOrNull { annotation ->
            Constants.MOCHA_ANNOTATIONS.any { it.isInstance(annotation) }
        }
    }

    inline fun <reified T> getConstructor(clazz: KClass<*>? = null): KFunction<T> {
        return (clazz?.primaryConstructor ?: T::class.constructors.first()) as KFunction<T>
    }
}



