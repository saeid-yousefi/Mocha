package ir.sy.mocha.core.strategy

import ir.sy.mocha.resources.Languages

interface MockStrategy<T> {
    fun mock(language: Languages): T
}