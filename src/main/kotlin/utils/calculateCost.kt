package utils

import classes.World

fun calculateCost(solution: List<Int>, world: World): Long {
    var totalCost: Long = 0
    var vehicleId = 0
    var currentNode = world.vehicles[vehicleId].homeNode
    val packages = BooleanArray(world.calls.size)
    val dummyVehicle = BooleanArray(world.calls.size)

    for (call in solution) {
        if (call == 0) {
            vehicleId++
            currentNode = -1
            continue
        }
        if (vehicleId > world.vehicles.size - 1) {
            if (!dummyVehicle[call - 1]) {
                totalCost += world.calls[call - 1].costNotTransport
                dummyVehicle[call - 1] = true
            }
            continue
        }
        // Switch to next car if current call is 0
        if (currentNode == -1) {
            currentNode = world.vehicles[vehicleId].homeNode
        }

        // Calculate travel cost between nodes
        val node = world.findNode(vehicleId, call - 1)
        val destinationNode = if (packages[call - 1]) {
            world.calls[call - 1].destinationNode
        } else {
            world.calls[call - 1].originNode
        }
        val travel = world.findTravel(vehicleId, currentNode, destinationNode)
        totalCost += travel.travelCost

        // Calculate cost for pickup/delivery
        totalCost += if (packages[call - 1]) {
            packages[call - 1] = false
            node.destinationCost
        } else {
            packages[call - 1] = true
            node.originCost
        }
        currentNode = destinationNode
    }
    return totalCost
}