package ir.sy.mocha.core.strategy

import android.content.Context
import ir.sy.mocha.mocker.data_creators.createData
import kotlin.reflect.KClass
import kotlin.reflect.full.createType
import kotlin.reflect.full.starProjectedType

class ListMockStrategy<T>(private val clazz: KClass<*>? = null) : MockStrategy<T> {
    override fun mock(context: Context): T {
        @Suppress("UNCHECKED_CAST")
        return createData(clazz?.createType(), context = context) as T
    }
}

