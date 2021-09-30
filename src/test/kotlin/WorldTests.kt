import classes.World
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import utils.parseInput
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WorldTests {
    private lateinit var world: World

    @BeforeAll
    fun setup() {
        world = parseInput("src/main/resources/Call_7_Vehicle_3.txt")
    }
    @Test
    fun `test that you find correct travel`() {
        val travel = world.findTravel(2, 0, 4)
        assertEquals(36418, travel.travelCost)
    }
}