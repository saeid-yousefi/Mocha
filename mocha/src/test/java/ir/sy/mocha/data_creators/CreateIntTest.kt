package ir.sy.mocha.data_creators

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.data_creators.createInt
import ir.sy.mocha.mocker.types.IntType

class CreateIntTest : BehaviorSpec({
    Given("valid variable name without annotations") {
        `when`("create data for id variable") {
            val variableName = "userId"
            val result = createInt(variableName)
            then("result should be in id range") {
                result shouldBeInRange 1..100000
            }
        }
        `when`("create data for age variable") {
            val variableName = "user_age"
            val result = createInt(variableName)
            then("result should be in id range") {
                result shouldBeInRange 1..120
            }
        }
    }

    Given("Variable name with annotations") {
        `when`("MockInt with id type") {
            val variableName = "sth"
            val mockInt = MockInt(type = IntType.Id)
            val result = createInt(variableName, mockInt)
            then("result should be in id range") {
                result shouldBeInRange 1..100000
            }
        }
        `when`("MockInt with custom type ") {
            val variableName = "sth"
            val min = 1
            val max = 20
            val factor = 5
            val mockInt = MockInt(type = IntType.Custom, min, max, factor)
            val result = createInt(variableName, mockInt)
            then("result should be in id range") {
                result shouldBeInRange min * factor..max * factor
                result % factor shouldBe 0
            }
        }
    }
})