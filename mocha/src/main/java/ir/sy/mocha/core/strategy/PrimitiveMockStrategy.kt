package ir.sy.mocha.core.strategy

import android.content.Context
import ir.sy.mocha.mocker.data_creators.createData
import ir.sy.mocha.resources.Languages
import ir.sy.mocha.utils.Constants
import kotlin.reflect.KClass
import kotlin.reflect.full.createType

class PrimitiveMockStrategy<T>(private val clazz: KClass<*>? = null) : MockStrategy<T> {
    @Suppress("UNCHECKED_CAST")
    override fun mock(language: Languages): T {
        return createData(
            annotation = findMochaAnnotations(clazz?.annotations.orEmpty()),
            language = language,
            type = clazz?.createType()
        ) as T
    }

    private fun findMochaAnnotations(annotations: List<Annotation>): Annotation? {
        return annotations.firstOrNull { annotation ->
            Constants.MOCHA_ANNOTATIONS.any { it.isInstance(annotation) }
        }
    }
}