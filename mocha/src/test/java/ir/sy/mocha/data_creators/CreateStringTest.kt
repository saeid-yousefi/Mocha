package ir.sy.mocha.data_creators

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import ir.sy.mocha.mocker.annotations.MockString
import ir.sy.mocha.mocker.data_creators.createString
import ir.sy.mocha.mocker.types.StringType
import ir.sy.mocha.resources.EnglishResources
import ir.sy.mocha.resources.Languages

class CreateStringTest : BehaviorSpec({
    val language = Languages.English
    Given("valid variable name without annotations") {
        `when`("create data for Name variable") {
            val variableName = "firstname"
            val result = createString(variableName, language)
            then("result should be name") {
                result shouldBeIn Languages.English.resources.name
            }
        }
        `when`("create data for Country") {
            val variableName = "user_nationality"
            val result = createString(variableName, language)
            then("result should be in countries") {
                result shouldBeIn Languages.English.resources.country
            }
        }
        `when`("create data for undefined variable") {
            val variableName = "aa_bb_cc"
            val result = createString(variableName, language)
            then("result should be in countries") {
                result shouldBeIn Languages.English.resources.undefined
            }
        }
    }
    Given("Variable name with Annotation") {
        val variableName = "sth"
        `when`("email annotation") {
            val annotation = MockString(type = StringType.Email)
            val result = createString(variableName, language, annotation)
            then("result should be email") {
                result shouldBeIn EnglishResources.email
            }
        }
        `when`("custom annotation with word count") {
            val annotation = MockString(type = StringType.Custom, wordCount = 1)
            val result = createString(variableName, language, annotation)
            then("result size should be 1") {
                result.split(" ").size shouldBe 1
            }
        }
        `when`("name annotation with persian language") {
            val annotation = MockString(type = StringType.Name)
            val result = createString(variableName, Languages.Persian, annotation)
            then("result should be name in persian") {
                result shouldBeIn Languages.Persian.resources.name
            }
        }
    }
})