package ir.sy.mocha.get_types

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.types.IntType
import ir.sy.mocha.mocker.types.getIntType

class GetIntTypesTest : BehaviorSpec({
    Given("A variable name for Integer") {
        `when`("variable is valid") {
            val variableName = "userAge"
            Then("result should be in age type") {
                val result = getIntType(variableName)
                result shouldBe IntType.Age
            }
        }
        `when`("variable name is valid") {
            val variableName = "item_price"
            Then("result should be in price type") {
                val result = getIntType(variableName)
                result shouldBe IntType.Price
            }
        }
        `when`("variable name is not valid") {
            val variableName = "aa_bb_cc"
            Then("result should be in undefined type") {
                val result = getIntType(variableName)
                result shouldBe IntType.Undefined
            }
        }
    }
})