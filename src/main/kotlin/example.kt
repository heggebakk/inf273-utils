import utils.calculateCost
import utils.feasibilityCheck
import utils.parseInput

fun main() {
    val world = parseInput("src/main/resources/Call_7_Vehicle_3.txt")
    val solution = listOf(7, 7, 5, 5, 0, 2, 2, 0, 3, 4, 4, 3, 1, 1, 0, 6, 6)

    val feasibility = feasibilityCheck(solution, world)
    val cost = calculateCost(solution, world)

    println("Feasible: ${feasibility.isOk()}, ${feasibility.message}")
    println("Cost: $cost")
}