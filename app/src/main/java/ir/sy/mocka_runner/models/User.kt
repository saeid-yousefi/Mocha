package ir.sy.mocka_runner.models

import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.types.LongType

data class User(
    val id: List<Int>,
    val price: Int,
    val name: String,
    val username: String,
    val email: String,
    @MockLong(type = LongType.Timestamp) val ts: Long,
    @MockString(defaultValue = "hello world") val string: String,
    val address: Address
)
