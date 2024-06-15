package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.StringType
import ir.sy.mocha.utils.Constants.DEFAULT_TAKEN_WORD_COUNTS

/**
 * Annotation for specifying mock string values.
 *
 * This annotation can be used on function parameters or types to indicate that a mock string value should be generated.
 * The generated string value can have a default value, a specific type, and a specified word count.
 *
 * @property defaultValue The default value of the string. Default is an empty string.
 * @property type The type of string to generate. Default is [StringType.Undefined].
 * @property wordCount The number of words to include in the generated string. Default is [DEFAULT_TAKEN_WORD_COUNTS].
 */
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockString(
    val defaultValue: String = "",
    val type: StringType = StringType.Undefined,
    val wordCount: Int = DEFAULT_TAKEN_WORD_COUNTS
)