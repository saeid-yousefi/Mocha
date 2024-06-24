package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.IntType

/**
 * Annotation for specifying mock integer values.
 *
 * This annotation can be used on function parameters to indicate that a mock integer value should be generated
 * for the parameter. The generated integer value will be constrained by the specified type, minimum and maximum values,
 * and a factor.
 *
 * @property type The type of integer to generate.
 * @property min The minimum value of the integer. Default is 1.
 * @property max The maximum value of the integer. Default is [Int.MAX_VALUE].
 * @property factor A factor to apply to the generated integer value. Default is 1.
 */
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class MockInt(
    val type: IntType,
    val min: Int = 1,
    val max: Int = Int.MAX_VALUE,
    val factor: Int = 1
)
