package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.FloatType

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockFloat(
    val type: FloatType,
    val min: Float = 0f,
    val max: Float = Float.MAX_VALUE,
    val factor: Int = 1
)
