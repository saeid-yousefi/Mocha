package ir.sy.mocha.mocker.data_creators

import android.content.Context
import android.content.res.Resources
import ir.sy.mocha.mocker.annotations.MockFloat
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.types.FloatType
import ir.sy.mocha.mocker.types.IntType
import ir.sy.mocha.mocker.types.LongType
import ir.sy.mocha.mocker.types.getFloatType
import ir.sy.mocha.mocker.types.getIntType
import ir.sy.mocha.mocker.types.getLongType
import ir.sy.mocha.mocker.types.getStringType
import ir.sy.mocha.utils.Constants
import ir.sy.mocha.utils.Constants.MAXIMUM_TIME_IN_MILLI_SECONDS
import ir.sy.mocha.utils.Constants.MINIMUM_TIME_IN_MILLI_SECONDS
import kotlin.random.Random

fun createInt(variableName: String, annotation: MockInt? = null): Int {

    val type = annotation?.type ?: getIntType(variableName)

    val intRange = IntRange(
        annotation?.min ?: 1,
        annotation?.max ?: Int.MAX_VALUE
    )
    val factor = annotation?.factor ?: 1

    return when (type) {
        IntType.Id -> createIntNumber(1..100000, 1)
        IntType.Age -> createIntNumber(1..120, 1)
        IntType.Boolean -> createIntNumber(0..1, 1)
        IntType.Count -> createIntNumber(1..100, 1)
        IntType.Day -> createIntNumber(1..31, 1)
        IntType.Measurement -> createIntNumber(1..1000, 1)
        IntType.Month -> createIntNumber(1..12, 1)
        IntType.Price -> createIntNumber(1..100, 15000)
        IntType.Rank -> createIntNumber(1..100, 1)
        IntType.TimeStamp -> createIntNumber(
            Constants.MINIMUM_EPOCH_DATE..Constants.MAXIMUM_EPOCH_DATE,
            1
        )

        IntType.Undefined -> createIntNumber(1..Int.MAX_VALUE, 1)
        IntType.Year -> createIntNumber(1960..2030, 1)
        IntType.Custom -> createIntNumber(intRange, factor)
    }
}

fun createFloat(variableName: String, annotation: MockFloat? = null): Float {

    val type = annotation?.type ?: getFloatType(variableName)

    val floatRange = annotation?.min?.rangeTo(annotation.max) ?: 1.0f..Float.MAX_VALUE
    val factor = annotation?.factor ?: 1
    return when (type) {
        FloatType.Height -> createFloatNumber(0.5f..2.5f, factor)
        FloatType.Weight -> createFloatNumber(3.0f..500.0f, factor)
        FloatType.Temperature -> createFloatNumber(-50.0f..50.0f, factor)
        FloatType.Speed -> createFloatNumber(0.0f..300.0f, factor)
        FloatType.Distance -> createFloatNumber(0.0f..10000.0f, factor)
        FloatType.Latitude -> createFloatNumber(-90.0f..90.0f, factor)
        FloatType.Longitude -> createFloatNumber(-180.0f..180.0f, factor)
        FloatType.Altitude -> createFloatNumber(-500.0f..10000.0f, factor)
        FloatType.Depth -> createFloatNumber(0.0f..11000.0f, factor)
        FloatType.Volume -> createFloatNumber(0.0f..10000.0f, factor)
        FloatType.Area -> createFloatNumber(0.0f..1000000.0f, factor)
        FloatType.Density -> createFloatNumber(0.0f..500.0f, factor)
        FloatType.Pressure -> createFloatNumber(0.0f..2000.0f, factor)
        FloatType.Humidity -> createFloatNumber(0.0f..100.0f, factor)
        FloatType.Angle -> createFloatNumber(0.0f..360.0f, factor)
        FloatType.Duration -> createFloatNumber(
            0.0f..86400.0f,
            factor
        ) // Duration in seconds (0 to 24 hours)
        FloatType.Rating -> createFloatNumber(0.0f..5.0f, factor)
        FloatType.Percentage -> createFloatNumber(0.0f..100.0f, factor)
        FloatType.ExchangeRate -> createFloatNumber(0.0f..1000.0f, factor)
        FloatType.Undefined -> createFloatNumber(1.0f..Float.MAX_VALUE, factor)
        FloatType.Custom -> createFloatNumber(floatRange, factor)
    }
}

fun createLong(variableName: String, annotation: MockLong? = null): Long {
    val type = annotation?.type ?: getLongType(variableName)

    val customLongRange =
        LongRange(start = annotation?.min ?: 1, endInclusive = annotation?.max ?: Long.MAX_VALUE)
    val customFactor = annotation?.factor ?: 1
    return when (type) {
        LongType.Id -> createLongNumber(1..1_000_000_000L, 1)
        LongType.Timestamp ->
            createLongNumber(MINIMUM_TIME_IN_MILLI_SECONDS..MAXIMUM_TIME_IN_MILLI_SECONDS, 1)

        LongType.Count -> createLongNumber(0..1_000_00L, 10)
        LongType.Size -> createLongNumber(1..1_000_000_000L, 1)
        LongType.Undefined -> createLongNumber(1..Long.MAX_VALUE, 1)
        LongType.Custom -> createLongNumber(customLongRange, customFactor)
    }
}

fun createDouble(): Double {
    return Random.nextDouble()
}

// TODO change getIdentifier
fun createString(variableName: String, context: Context, annotation: MockString? = null): String {
    val type = annotation?.type ?: getStringType(variableName)
    val wordCount = annotation?.wordCount
    val defaultValue = annotation?.defaultValue
    if (!defaultValue.isNullOrBlank()) return defaultValue

    val resourceId =
        context.resources.getIdentifier(
            "mocha_${type.name.lowercase()}",
            "array",
            context.packageName
        )

    if (resourceId == 0) {
        throw Resources.NotFoundException("Resource not found for type: ${type.name.lowercase()}")
    }

    val stringArray = context.resources.getStringArray(resourceId)
    if (stringArray.isEmpty()) {
        throw IllegalArgumentException("String array for type: ${type.name.lowercase()} is empty")
    }

    val randomIndex = Random.nextInt(stringArray.size)
    val selectedString = stringArray[randomIndex]

    return if (wordCount == null) {
        selectedString
    } else {
        selectedString.split(" ").take(wordCount).joinToString(" ")
    }
}

fun createBoolean(): Boolean {
    return Random.nextBoolean()
}

private fun createIntNumber(range: IntRange, factor: Int): Int {
    return Random.nextInt(range.first, range.last) * factor
}

private fun createLongNumber(range: LongRange, factor: Int): Long {
    return Random.nextLong(range.first, range.last) * factor
}

fun createFloatNumber(range: ClosedFloatingPointRange<Float>, factor: Int): Float {
    return (Random.nextFloat() * (range.endInclusive - range.start) + range.start) * factor
}


