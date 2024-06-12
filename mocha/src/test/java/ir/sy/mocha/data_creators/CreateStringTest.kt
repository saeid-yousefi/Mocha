package ir.sy.mocha.data_creators

import android.content.Context
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.data_creators.createString
import ir.sy.mocha.mocker.data_creators.getStringArrayFromResources
import ir.sy.mocha.mocker.types.StringType

class CreateStringTest : BehaviorSpec({
    val context = mockk<Context>(relaxed = true)

    Given("valid variable name without annotations") {
        `when`("create data for Name variable") {
            val names = arrayOf("john", "smith")
            every { getStringArrayFromResources(context, "mocha_name") } returns names
            val variableName = "firstname"
            val result = createString(variableName, context)
            then("result should be name") {
                result shouldBeIn names
            }
        }
        `when`("create data for Country") {
            val countries = arrayOf("country1", "country2")
            every { getStringArrayFromResources(context, "mocha_country") } returns countries
            val variableName = "user_nationality"
            val result = createString(variableName, context)
            then("result should be in countries") {
                result shouldBeIn countries
            }
        }
        `when`("create data for undefined variable") {
            val items = arrayOf("item1", "item2")
            every { getStringArrayFromResources(context, "mocha_undefined") } returns items
            val variableName = "aa_bb_cc"
            val result = createString(variableName, context)
            then("result should be in countries") {
                result shouldBeIn items
            }
        }
    }
    Given("Variable name with Annotation") {
        val variableName = "sth"
        `when`("email annotation") {
            val emails = arrayOf("email@email.com")
            every { getStringArrayFromResources(context, "mocha_email") } returns emails
            val annotation = MockString(type = StringType.Email)
            val result = createString(variableName, context, annotation)
            then("result should be email") {
                result shouldBeIn emails
            }
        }
        `when`("custom annotation with word count") {
            val items = arrayOf("The quick brown")
            every { getStringArrayFromResources(context, "mocha_custom") } returns items
            val annotation = MockString(type = StringType.Custom, wordCount = 1)
            val result = createString(variableName, context, annotation)
            then("result should be The") {
                result shouldBe "The"
            }
        }
    }
})