package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.LongType

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockLong(
    val type: LongType,
    val min: Long = 1,
    val max: Long = Long.MAX_VALUE,
    val factor: Int = 1
)
