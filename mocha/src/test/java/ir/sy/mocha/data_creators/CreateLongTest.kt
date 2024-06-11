package ir.sy.mocha.data_creators

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeInRange
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.annotations.MockLong
import ir.sy.mocha.mocker.data_creators.createLong
import ir.sy.mocha.mocker.types.LongType
import ir.sy.mocha.utils.Constants

class CreateLongTest : BehaviorSpec({
    Given("valid variable name without annotations") {
        `when`("create data for timestamp variable") {
            val variableName = "timestamp"
            val result = createLong(variableName)
            then("result should be in timestamp range") {
                result shouldBeInRange Constants.MINIMUM_TIME_IN_MILLI_SECONDS..Constants.MAXIMUM_TIME_IN_MILLI_SECONDS
            }
        }
        `when`("create data for unknown variable name") {
            val variableName = "aa_bb_cc"
            val result = createLong(variableName)
            then("result should be in id range") {
                result shouldBeInRange 1L..Long.MAX_VALUE
            }
        }
    }

    Given("Variable name with annotations") {
        `when`("MockLong with custom type ") {
            val variableName = "sth"
            val min = 1L
            val max = Long.MAX_VALUE / 4
            val factor = 2
            val mockLong = MockLong(type = LongType.Custom, min, max, factor)
            val result = createLong(variableName, mockLong)
            then("result should be in id range") {
                result shouldBeInRange min * factor..max * factor
                result % factor shouldBe 0
            }
        }
    }
})