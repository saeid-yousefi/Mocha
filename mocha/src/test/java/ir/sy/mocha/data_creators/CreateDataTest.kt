package ir.sy.mocha.data_creators

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.every
import io.mockk.mockkStatic
import ir.sy.mocha.mocker.data_creators.createData
import ir.sy.mocha.mocker.data_creators.createInt
import ir.sy.mocha.mocker.data_creators.createString
import ir.sy.mocha.resources.Languages
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf

class CreateDataTest : BehaviorSpec({
    val variableName = "sth"
    val variableValue = "value"
    val language = Languages.English

    beforeTest {
        mockkStatic("ir.sy.mocha.mocker.data_creators.PrimitiveDataCreatorKt")
        every { createInt(variableName, null) } returns 1
        every { createString(variableName, language) } returns variableValue
    }

    Given("a variable name with type") {
        `when`("create an integer data") {
            val result =
                createData(type = typeOf<Int>(), variableName = variableName, language = language)
            then("result should be 1") {
                result shouldBe 1
            }
        }
        `when`("create a string data") {
            val result = createData(
                type = typeOf<String>(),
                variableName = variableName,
                language = language
            )
            then("result should be name") {
                result shouldBe variableValue
            }
        }
        `when`("create a simple list") {
            val result = createData(typeOf<List<Int>>(), variableName = variableName)
            then("result should be list of ints") {
                (result is List<*>) shouldBe true
            }
        }
        `when`("create a child data class") {
            data class Foo(val id: Int)

            val result = createData(type = Foo::class.createType())
            then("the result should be Foo") {
                result.shouldBeInstanceOf<Foo>()
            }
        }
    }
})