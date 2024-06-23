package ir.sy.mocha.core.strategy

import android.content.Context
import ir.sy.mocha.mocker.data_creators.createData
import ir.sy.mocha.utils.Constants
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor

class ConstructorMockStrategy<T>(private val clazz: KClass<*>? = null) : MockStrategy<T> {
    override fun mock(context: Context): T {
        val constructor: KFunction<T> = getConstructor(clazz)
        val args = constructor.parameters
            .map { parameter ->
                createData(
                    parameter.type,
                    parameter.name,
                    findMochaAnnotations(parameter.annotations),
                    context
                )
            }.toTypedArray()
        return constructor.call(*args)
    }

    @Suppress("UNCHECKED_CAST")
    private fun getConstructor(clazz: KClass<*>? = null): KFunction<T> {
        return (clazz?.primaryConstructor) as KFunction<T>
    }

    private fun findMochaAnnotations(annotations: List<Annotation>): Annotation? {
        return annotations.firstOrNull { annotation ->
            Constants.MOCHA_ANNOTATIONS.any { it.isInstance(annotation) }
        }
    }
}