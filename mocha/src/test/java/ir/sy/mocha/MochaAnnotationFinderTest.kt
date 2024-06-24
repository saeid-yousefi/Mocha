package ir.sy.mocha

import android.content.Context
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import ir.sy.mocha.core.Mocha
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.types.IntType

class MochaAnnotationFinderTest : BehaviorSpec({

    val context = spyk<Context>()
    val mocha = Mocha(context)

    Given("a list of annotations including MochaAnnotation") {
        val item = MockInt(type = IntType.Price)
        val annotations = listOf(item)
        `when`("finding Mocha annotations") {
            val result = mocha.findMochaAnnotations(annotations)
            Then("it should return the Mocha annotation") {
                result shouldBe item
            }
        }
    }

    Given("a list of annotations without MochaAnnotation") {
        val item = mockk<Annotation>()
        val annotations = listOf(item)
        `when`("finding Mocha annotations") {
            val result = mocha.findMochaAnnotations(annotations)
            then("it should return null") {
                result shouldBe null
            }
        }
    }

    Given("an empty list of annotations") {
        val annotations = emptyList<Annotation>()
        `when`("finding Mocha annotations") {
            val result = mocha.findMochaAnnotations(annotations)
            then("it should return null") {
                result shouldBe null
            }
        }
    }
})