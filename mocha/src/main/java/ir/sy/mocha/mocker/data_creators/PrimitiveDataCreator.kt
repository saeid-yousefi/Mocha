package ir.sy.mocha.mocker.data_creators

import android.content.Context
import ir.sy.mocha.core.mock
import ir.sy.mocha.mocker.annotations.MockFloat
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.isBoolean
import ir.sy.mocha.mocker.isDouble
import ir.sy.mocha.mocker.isFloat
import ir.sy.mocha.mocker.isInt
import ir.sy.mocha.mocker.isList
import ir.sy.mocha.mocker.isListOrIterable
import ir.sy.mocha.mocker.isLong
import ir.sy.mocha.mocker.isString
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
import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.jvm.jvmErasure


/**
 * Creates data for the specified type.
 *
 * @param type The type of the data to create.
 * @param variableName The name of the variable.
 * @param annotation The annotation associated with the variable.
 * @return An instance of the created data.
 */
fun createData(
    type: KType? = null,
    variableName: String? = null,
    annotation: Annotation? = null,
    context: Context
): Any? {
    return when {
        type?.isInt() == true ->
            createInt(
                variableName.toString(),
                if (annotation == null) null else annotation as MockInt
            )

        type?.isString() == true -> createString(
            variableName = variableName.toString(),
            context = context,
            annotation = if (annotation == null) null else annotation as MockString
        )

        type?.isFloat() == true -> createFloat(
            variableName = variableName.toString(),
            annotation = if (annotation == null) null else annotation as MockFloat
        )

        type?.isLong() == true -> createLong(
            variableName = variableName.toString(),
            annotation = if (annotation == null) null else annotation as MockLong
        )

        type?.isBoolean() == true -> createBoolean()

        type?.isDouble() == true -> createDouble()

        type?.jvmErasure.isListOrIterable() -> List(2) {
            createData(
                type = type?.arguments?.first()?.type,
                context = context
            )
        }

        else -> type?.jvmErasure?.let { mock(it, context) }
    }
}

/**
 * Generates a mock integer value based on the provided variable name and annotation.
 *
 * @param variableName The name of the variable for which the mock integer is generated.
 * @param annotation An optional [MockInt] annotation to specify the mock integer properties.
 * @return A mock integer value.
 */
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

/**
 * Generates a mock float value based on the provided variable name and annotation.
 *
 * @param variableName The name of the variable for which the mock float is generated.
 * @param annotation An optional [MockFloat] annotation to specify the mock float properties.
 * @return A mock float value.
 */
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

/**
 * Generates a mock long value based on the provided variable name and annotation.
 *
 * @param variableName The name of the variable for which the mock long is generated.
 * @param annotation An optional [MockLong] annotation to specify the mock long properties.
 * @return A mock long value.
 */
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

/**
 * Generates a mock string value based on the provided variable name, context, and annotation.
 *
 * @param variableName The name of the variable for which the mock string is generated.
 * @param context The context from which to obtain resources.
 * @param annotation An optional [MockString] annotation to specify the mock string properties.
 * @return A mock string value.
 * @throws IllegalArgumentException if the string array for the specified type is empty.
 */

fun createString(variableName: String, context: Context, annotation: MockString? = null): String {
    val type = annotation?.type ?: getStringType(variableName)
    val wordCount = annotation?.wordCount
    val defaultValue = annotation?.defaultValue
    if (!defaultValue.isNullOrBlank()) return defaultValue

    val stringArray = getStringArrayFromResources(context, "mocha_${type.name.lowercase()}")
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

internal fun getStringArrayFromResources(context: Context, arrayName: String): Array<String> {
    val resourceId =
        context.resources.getIdentifier(arrayName, "array", context.packageName)

    return context.resources.getStringArray(resourceId)
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


