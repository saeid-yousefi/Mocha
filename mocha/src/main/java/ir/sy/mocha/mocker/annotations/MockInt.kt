package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.IntType

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockInt(
    val type: IntType,
    val min: Int = 1,
    val max: Int = Int.MAX_VALUE,
    val factor: Int = 1
)
