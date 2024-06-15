package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.LongType

/**
 * Annotation for specifying mock long values.
 *
 * This annotation can be used on function parameters to indicate that a mock long value should be generated
 * for the parameter. The generated long value will be constrained by the specified type, minimum and maximum values,
 * and a factor.
 *
 * @property type The type of long to generate.
 * @property min The minimum value of the long. Default is 1.
 * @property max The maximum value of the long. Default is [Long.MAX_VALUE].
 * @property factor A factor to apply to the generated long value. Default is 1.
 */
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockLong(
    val type: LongType,
    val min: Long = 1,
    val max: Long = Long.MAX_VALUE,
    val factor: Int = 1
)
