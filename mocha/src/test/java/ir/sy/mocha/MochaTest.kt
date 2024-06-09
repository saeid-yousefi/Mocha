package ir.sy.mocha

import android.content.Context
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import ir.sy.mocha.mocker.annotations.MockInt
import ir.sy.mocha.mocker.types.IntType
import org.junit.Before
import org.junit.Test


class MochaTest {
    @MockK
    private lateinit var mockContext: Context

    lateinit var mocha: Mocha

    @Before
    fun setUp() {
        MockKAnnotations.init(this);
        mocha = Mocha(mockContext)
    }

    @Test
    fun findMochaAnnotations_withValidInput_returnsAnnotations() {
        val item = MockInt(type = IntType.Price)
        val validInput = listOf(item)
        val result = mocha.findMochaAnnotations(validInput)
        assertThat(result).isEqualTo(item)
    }

    @Test
    fun findMochaAnnotations_withInValidInput_returnsNull() {
        val item = mockk<Annotation>()
        val validInput = listOf(item)
        val result = mocha.findMochaAnnotations(validInput)
        assertThat(result).isEqualTo(null)
    }
}