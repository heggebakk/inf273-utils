import classes.StateResult
import classes.World
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import utils.feasibilityCheck
import utils.parseInput

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FeasibilityCheckTests() {
    private lateinit var world: World
    private lateinit var solution: List<Int>
    private var cost: Int = 0

    @BeforeAll
    fun setup() {
        world = parseInput("src/main/resources/Call_7_Vehicle_3.txt")
    }

    @Test
    fun `test feasibility check ends with correct code 1`() {
        solution = listOf(7, 7, 5, 5, 0, 2, 2, 0, 3, 4, 4, 3, 1, 1, 0, 6, 6)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.InvalidCall("Call 5 is not valid for vehicle 1")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 2`() {
        solution = listOf(1, 1, 0, 7, 7, 3, 3, 0, 5, 5, 6, 6, 0, 4, 4, 2, 2)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 3`() {
        solution = listOf(0, 3, 3, 0, 1, 1, 0, 5, 6, 2, 7, 7, 6, 4, 2, 4, 5)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 4`() {
    solution = listOf(3, 3, 0, 0, 7, 7, 1, 1, 0, 5, 4, 6, 2, 5, 6, 4, 2)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 5`() {
    solution = listOf(7, 7, 0, 1, 1, 0, 5, 5, 6, 6, 0, 3, 2, 3, 4, 2, 4)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 6`() {
        solution = listOf(0, 7, 7, 3, 3, 0, 5, 5, 0, 1, 4, 1, 2, 6, 2, 6, 4)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }

    @Test
    fun `test feasibility check ends with correct code 7`() {
    solution = listOf(1, 1, 0, 7, 7, 0, 2, 2, 0, 3, 4, 5, 6, 4, 5, 3, 6)
        val actual = feasibilityCheck(solution, world)
        val expected = StateResult.Ok("Ok")
        assertEquals(expected.message, actual.message)
        assertEquals(expected::class, actual::class)
    }
}