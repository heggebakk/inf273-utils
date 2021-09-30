import classes.World
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import utils.calculateCost
import utils.parseInput

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculateCostTests() {
    private lateinit var world: World
    private lateinit var solution: List<Int>
    private var cost: Long = 0

    @BeforeAll
    fun setup() {
        world = parseInput("src/main/resources/Call_7_Vehicle_3.txt")
    }

    @Test
    fun `test get cost function calculates correct sum 1`() {
        solution = listOf(7, 7, 5, 5, 0, 2, 2, 0, 3, 4, 4, 3, 1, 1, 0, 6, 6)
        cost = calculateCost(solution, world)
        assertEquals(1439159, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 2`() {
        solution = listOf(1, 1, 0, 7, 7, 3, 3, 0, 5, 5, 6, 6, 0, 4, 4, 2, 2)
        cost = calculateCost(solution, world)
        assertEquals(1477429, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 3`() {
        solution = listOf(0, 3, 3, 0, 1, 1, 0, 5, 6, 2, 7, 7, 6, 4, 2, 4, 5)
        cost = calculateCost(solution, world)
        assertEquals(2672316, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 4`() {
        solution = listOf(3, 3, 0, 0, 7, 7, 1, 1, 0, 5, 4, 6, 2, 5, 6, 4, 2)
        cost = calculateCost(solution, world)
        assertEquals(2346070, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 5`() {
        solution = listOf(7, 7, 0, 1, 1, 0, 5, 5, 6, 6, 0, 3, 2, 3, 4, 2, 4)
        cost = calculateCost(solution, world)
        assertEquals(1617415, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 6`() {
        solution = listOf(0, 7, 7, 3, 3, 0, 5, 5, 0, 1, 4, 1, 2, 6, 2, 6, 4)
        cost = calculateCost(solution, world)
        assertEquals(2478319, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 7`() {
        solution = listOf(1, 1, 0, 7, 7, 0, 2, 2, 0, 3, 4, 5, 6, 4, 5, 3, 6)
        cost = calculateCost(solution, world)
        assertEquals(2166916, cost)
    }

    @Test
    fun `test get cost function calculates correct sum 8`() {
        solution = listOf(0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7)
        cost = calculateCost(solution, world)
        assertEquals(3286422, cost)
    }

    @Test
    fun `test solution`() {
        solution = listOf(12, 12, 29, 11, 29, 11, 2, 2, 9, 9, 0, 34, 5, 5, 34, 20, 20, 27, 27, 4, 4, 0, 21, 21, 3, 3, 10, 14, 14, 10, 15, 15, 0, 25, 25, 8, 22, 22, 33, 33, 31, 31, 8, 0, 19, 23, 23, 18, 18, 19, 32, 32, 0, 7, 17, 17, 7, 30, 24, 24, 30, 26, 26, 0, 28, 28, 13, 13, 1, 1, 0, 6, 6, 16, 16, 35, 35)
        val world2 = parseInput("src/main/resources/Call_035_Vehicle_07.txt")
        cost = calculateCost(solution, world2)
        val result = 6001019L
        assertEquals(cost, result)
    }
}