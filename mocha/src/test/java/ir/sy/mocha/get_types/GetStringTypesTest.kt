package ir.sy.mocha.get_types

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.types.StringType
import ir.sy.mocha.mocker.types.getStringType

class GetStringTypesTest : BehaviorSpec({
    Given("A variable name for String") {
        `when`("variable is valid") {
            val variableName = "firstname"
            Then("result should be in name type") {
                val result = getStringType(variableName)
                result shouldBe StringType.Name
            }
        }
        `when`("variable name is valid") {
            val variableName = "descr"
            Then("result should be in desc type") {
                val result = getStringType(variableName)
                result shouldBe StringType.Description
            }
        }
        `when`("variable name is not valid") {
            val variableName = "aa_bb_cc"
            Then("result should be in undefined type") {
                val result = getStringType(variableName)
                result shouldBe StringType.Undefined
            }
        }
    }
})