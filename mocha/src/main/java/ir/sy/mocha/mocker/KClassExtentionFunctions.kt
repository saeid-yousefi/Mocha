package ir.sy.mocha.mocker

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

fun KClass<*>?.isListOrIterable(): Boolean {
    return this?.isSubclassOf(List::class) == true || this?.isSubclassOf(Iterable::class) == true
}