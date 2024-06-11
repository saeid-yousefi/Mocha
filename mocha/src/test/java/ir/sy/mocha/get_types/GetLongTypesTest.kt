package ir.sy.mocha.get_types

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.types.LongType
import ir.sy.mocha.mocker.types.getLongType

class GetLongTypesTest : BehaviorSpec({
    Given("A variable name for Long") {
        `when`("variable is valid") {
            val variableName = "timestamp"
            Then("result should be in timestamp type") {
                val result = getLongType(variableName)
                result shouldBe LongType.Timestamp
            }
        }

        `when`("variable name is not valid") {
            val variableName = "aa_bb_cc"
            Then("result should be in undefined type") {
                val result = getLongType(variableName)
                result shouldBe LongType.Undefined
            }
        }
    }
})