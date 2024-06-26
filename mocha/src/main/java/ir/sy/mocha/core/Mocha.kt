package ir.sy.mocha.core

import ir.sy.mocha.core.strategy.ConstructorMockStrategy
import ir.sy.mocha.core.strategy.MockStrategy
import ir.sy.mocha.core.strategy.PrimitiveMockStrategy
import ir.sy.mocha.resources.Languages
import kotlin.reflect.KClass

fun <T : Any> mock(clazz: KClass<T>, language: Languages = Languages.English): T {
    val strategy: MockStrategy<T>? = when {
        clazz.java.isPrimitive -> PrimitiveMockStrategy(clazz)
        clazz.constructors.isNotEmpty() -> ConstructorMockStrategy(clazz)
        else -> {
            null
        }
    }
    return strategy?.mock(language)!!
}