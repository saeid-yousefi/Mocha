package ir.sy.mocha.core.strategy

import android.content.Context
import ir.sy.mocha.mocker.data_creators.createData
import ir.sy.mocha.utils.Constants
import kotlin.reflect.KClass
import kotlin.reflect.full.createType

class PrimitiveMockStrategy<T>(private val clazz: KClass<*>? = null) : MockStrategy<T> {
    @Suppress("UNCHECKED_CAST")
    override fun mock(context: Context): T {
        return createData(
            annotation = findMochaAnnotations(clazz?.annotations.orEmpty()),
            type = clazz?.createType(),
            context = context
        ) as T
    }

    private fun findMochaAnnotations(annotations: List<Annotation>): Annotation? {
        return annotations.firstOrNull { annotation ->
            Constants.MOCHA_ANNOTATIONS.any { it.isInstance(annotation) }
        }
    }
}