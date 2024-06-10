package ir.sy.mocha

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeLessThan

class MochaAnnotationFinderTest : BehaviorSpec({
    beforeTest {

    }
    Given("a list of annotations") {
        `when`("finding mocha") {
            Then("found") {
                println("hello")
                1 shouldBeLessThan 10
            }
        }

        `when`("finding mocha") {
            Then("found") {
                println("hello")
                5 shouldBeLessThan 10
            }
        }
    }
})