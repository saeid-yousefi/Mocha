package ir.sy.mocha

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import ir.sy.mocha.core.strategy.ConstructorMockStrategy
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.types.IntType
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

class MochaAnnotationFinderTest : BehaviorSpec({

    val method =
        ConstructorMockStrategy::class.declaredMemberFunctions.find { it.name == "findMochaAnnotations" }
    method?.isAccessible = true
    val classUnderTest = ConstructorMockStrategy<String>()

    Given("a list of annotations including MochaAnnotation") {
        val item = MockInt(type = IntType.Price)
        val annotations = listOf(item)
        `when`("finding Mocha annotations") {
            val result = method?.call(classUnderTest, annotations)
            Then("it should return the Mocha annotation") {
                result shouldBe item
            }
        }
    }

    Given("a list of not MochaAnnotation") {
        val annotations = listOf(Deprecated("STH"))
        `when`("finding Mocha annotations") {
            val result = method?.call(classUnderTest, annotations)
            Then("it should return the Mocha annotation") {
                result shouldBe null
            }
        }
    }
    Given("empty list of annotation") {
        val annotations = listOf<Annotation>()
        `when`("finding Mocha annotations") {
            val result = method?.call(classUnderTest, annotations)
            Then("it should return the Mocha annotation") {
                result shouldBe null
            }
        }
    }
})