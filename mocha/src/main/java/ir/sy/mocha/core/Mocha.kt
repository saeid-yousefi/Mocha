package ir.sy.mocha.core

import android.content.Context
import ir.sy.mocha.core.strategy.ConstructorMockStrategy
import ir.sy.mocha.core.strategy.MockStrategy
import kotlin.reflect.KClass

fun <T : Any> mock(type: KClass<T>, context: Context): T {
    val strategy: MockStrategy<T>? = when {
        type.constructors.isNotEmpty() -> ConstructorMockStrategy(type)
        else -> {
            null
        }
    }
    return strategy?.mock(context)!!
}