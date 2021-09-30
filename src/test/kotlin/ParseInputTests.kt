import classes.World
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import utils.parseInput

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParseInputTests() {
    private lateinit var world: World
    private lateinit var solution: List<Int>
    private var cost: Int = 0

    @BeforeAll
    fun setup() {
        world = parseInput("src/main/resources/Call_7_Vehicle_3.txt")
    }

    @Test
    fun `test all vehicles is added`() {
        assertEquals(3, world.vehicles.size)
    }

    @Test
    fun `test all calls is added`() {
        assertEquals(7, world.calls.size)
    }
    @Test
    fun `test all nodes with time and cost is added`() {
        assertEquals(21, world.nodes.size)
    }

    @Test
    fun `test each vehicle has all calls`() {
        assertEquals(3, world.vehicles[0].validCalls.size)
        assertEquals(3, world.vehicles[1].validCalls.size)
        assertEquals(7, world.vehicles[2].validCalls.size)
    }

    @Test
    fun `test all travels is added`() {
        assertEquals(1521, world.travels[0].size)
        assertEquals(1521, world.travels[1].size)
        assertEquals(1521, world.travels[2].size)
    }
}
