package ir.sy.mocha.utils

import ir.sy.mocha.mocker.annotations.MockFloat
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString

internal object Constants {
    const val MINIMUM_EPOCH_DATE = 642_960_051
    const val MINIMUM_TIME_IN_MILLI_SECONDS = 328_694_213_000L
    const val MAXIMUM_TIME_IN_MILLI_SECONDS = 1_717_228_613_000L
    const val MAXIMUM_EPOCH_DATE = 1_715_961_651
    const val DEFAULT_TAKEN_WORD_COUNTS = 5
    val MOCHA_ANNOTATIONS = listOf(
        MockInt::class,
        MockString::class,
        MockFloat::class,
        MockLong::class,
    )
}