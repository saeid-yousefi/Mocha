package ir.sy.mocha.mocker

import kotlin.reflect.KParameter
import kotlin.reflect.KType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.withNullability
import kotlin.reflect.typeOf

fun KParameter.typeIs(type: KType) = this.type == type
fun KType.isInt() = this == typeOf<Int>() || this == typeOf<Int?>()
fun KType.isString() = this == typeOf<String>() || this == typeOf<String?>()
fun KType.isBoolean() = this == typeOf<Boolean>() || this == typeOf<Boolean?>()
fun KType.isFloat() = this == typeOf<Float>() || this == typeOf<Float?>()
fun KType.isDouble() = this == typeOf<Double>() || this == typeOf<Double?>()
fun KType.isLong() = this == typeOf<Long>() || this == typeOf<Long?>()
fun KType.isList() = isListOfType<Any>(this)

private inline fun <reified T> isListOfType(type: KType): Boolean {
    val listType = typeOf<List<T>>()
    val nullableListType = listType.withNullability(true)

    return type.isSubtypeOf(listType) || type.isSubtypeOf(nullableListType)
}