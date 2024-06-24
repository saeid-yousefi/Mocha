package ir.sy.mocha.core

import android.content.Context
import ir.sy.mocha.core.strategy.ConstructorMockStrategy
import ir.sy.mocha.core.strategy.MockStrategy
import ir.sy.mocha.core.strategy.PrimitiveMockStrategy
import kotlin.reflect.KClass

fun <T : Any> mock(clazz: KClass<T>, context: Context): T {
    val strategy: MockStrategy<T>? = when {
        clazz.java.isPrimitive -> PrimitiveMockStrategy(clazz)
        clazz.constructors.isNotEmpty() -> ConstructorMockStrategy(clazz)
        else -> {
            null
        }
    }
    return strategy?.mock(context)!!
}