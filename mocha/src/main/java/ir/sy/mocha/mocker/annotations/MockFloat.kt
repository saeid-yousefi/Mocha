package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.FloatType

/**
 * Annotation for specifying mock float values.
 *
 * This annotation can be used on function parameters to indicate that a mock float value should be generated
 * for the parameter. The generated float value will be constrained by the specified type, minimum and maximum values,
 * and a factor.
 *
 * @property type The type of float to generate.
 * @property min The minimum value of the float. Default is 0f.
 * @property max The maximum value of the float. Default is [Float.MAX_VALUE].
 * @property factor A factor to apply to the generated float value. Default is 1.
 */

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockFloat(
    val type: FloatType,
    val min: Float = 0f,
    val max: Float = Float.MAX_VALUE,
    val factor: Int = 1
)
