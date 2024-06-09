package ir.sy.mocha.mocker.annotations

import ir.sy.mocha.mocker.types.StringType
import ir.sy.mocha.utils.Constants.DEFAULT_TAKEN_WORD_COUNTS

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
annotation class MockString(
    val defaultValue: String = "",
    val type: StringType = StringType.Undefined,
    val wordCount: Int = DEFAULT_TAKEN_WORD_COUNTS
)