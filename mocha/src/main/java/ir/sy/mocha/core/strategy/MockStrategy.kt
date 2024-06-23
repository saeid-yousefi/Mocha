package ir.sy.mocha.core.strategy

import android.content.Context

interface MockStrategy<T> {
    fun mock(context: Context): T
}