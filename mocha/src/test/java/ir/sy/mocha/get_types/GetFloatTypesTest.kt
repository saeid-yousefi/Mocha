package ir.sy.mocha.get_types

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.types.FloatType
import ir.sy.mocha.mocker.types.getFloatType

class GetFloatTypesTest : BehaviorSpec({
    Given("A variable name for Long") {
        `when`("variable is valid") {
            val variableName = "item_speed"
            Then("result should be in Speed type") {
                val result = getFloatType(variableName)
                result shouldBe FloatType.Speed
            }
        }

        `when`("variable is valid") {
            val variableName = "itemDensity"
            Then("result should be in density type") {
                val result = getFloatType(variableName)
                result shouldBe FloatType.Density
            }
        }

        `when`("variable name is not valid") {
            val variableName = "aa_bb_cc"
            Then("result should be in undefined type") {
                val result = getFloatType(variableName)
                result shouldBe FloatType.Undefined
            }
        }
    }
})