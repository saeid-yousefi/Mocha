package ir.sy.mocha

import android.content.Context
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import ir.sy.mocha.mocker.data_creators.createInt
import ir.sy.mocha.mocker.data_creators.createString
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf

class CreateDataTest : BehaviorSpec({
    val context = mockk<Context>(relaxed = true)
    val mocha = Mocha(context)
    val variableName = "sth"

    beforeTest {
        mockkStatic("ir.sy.mocha.mocker.data_creators.DataCreatorKt")
        every { createInt(variableName, null) } returns 1
        every { createString(variableName, context) } returns "name"
    }

    Given("a variable name with type") {
        `when`("create an integer data") {
            val result = mocha.createData(type = typeOf<Int>(), variableName = variableName)
            then("result should be 1") {
                result shouldBe 1
            }
        }
        `when`("create a string data") {
            val result = mocha.createData(type = typeOf<String>(), variableName = variableName)
            then("result should be name") {
                result shouldBe "name"
            }
        }
        `when`("create a simple list") {
            every { mocha.createData(type = typeOf<Int>()) } returns 1
            val result = mocha.createData(typeOf<List<Int>>())
            val expectedList = listOf(1, 1)
            then("result should be list of ints") {
                result shouldBe expectedList
            }
        }
        `when`("create a data class") {
            data class Foo(val id: Int)

            val expectedResult = Foo(1)
            every { mocha.mock<Foo>() } returns expectedResult
            val result = mocha.createData(type = typeOf<Foo>())

            then("result should be instance of Foo") {
                result shouldBe expectedResult
            }
        }
    }
})