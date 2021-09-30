package utils

import classes.StateResult
import classes.World

fun feasibilityCheck(solution: List<Int>, world: World): StateResult {
    var vehicleId = 0
    var vehicle = world.vehicles[vehicleId]
    var currentWeight = 0
    var currentTravelTime = vehicle.startingTime
    var currentNode = world.vehicles[vehicleId].homeNode
    val packs = BooleanArray(world.calls.size)
    if (solution.size != ((world.calls.size * 2) + world.vehicles.size)) {
        return StateResult.CapacityExceeded("")
    }

    for (call in solution) {
        // Switch to next car if current call is 0
        if (call == 0) {
            if (packs.any { it }) {
                return StateResult.PackagesNotDelivered("Packages not delivered")
            }
            vehicleId++
            if (vehicleId > world.vehicles.size - 1) return StateResult.Ok("Ok")
            vehicle = world.vehicles[vehicleId]
            currentWeight = 0
            currentNode = world.vehicles[vehicleId].homeNode
            currentTravelTime = vehicle.startingTime
            continue
        }

        // Check if current call is valid
        if (!vehicle.validCalls.contains(call - 1)) {
            world.isFeasible = false
            return StateResult.InvalidCall("Call $call is not valid for vehicle ${vehicleId + 1}")
        }

        // Find destination node and calculate travel time
        val node = world.findNode(vehicleId, call - 1)
        val destinationNode = if (packs[call -1]) {
            world.calls[call - 1].destinationNode
        } else {
            world.calls[call - 1].originNode
        }
        val travel = world.findTravel(vehicleId, currentNode, destinationNode)
        currentTravelTime += travel.travelTime

        // Check if arrival time is in time window, if not return or change current time
        if (packs[call - 1]) {
            if (world.calls[call - 1].deliverLowerTW > currentTravelTime) {
                currentTravelTime = world.calls[call - 1].deliverLowerTW
            }
            if (world.calls[call - 1].deliverUpperTW < currentTravelTime) {
                return StateResult.TimeWindowExceeded(
                    "Time window for delivering call $call exceeded. " +
                            "Current time: $currentTravelTime, Time window: ${world.calls[call - 1].deliverUpperTW}"
                )
            }
            packs[call - 1] = false
            currentWeight -= world.calls[call - 1].size
            currentTravelTime += node.destinationTime
        } else {
            if (world.calls[call - 1].pickupLowerTW > currentTravelTime) {
                currentTravelTime = world.calls[call - 1].pickupLowerTW
            }
            if (world.calls[call - 1].pickupUpperTW < currentTravelTime) {
                return StateResult.TimeWindowExceeded(
                    "Time window for pickup call $call exceeded. " +
                            "Current time: $currentTravelTime, Time window: ${world.calls[call - 1].pickupUpperTW}"
                )
            }
            // Check if capacity is exceeded or not, add package
            if (currentWeight + world.calls[call - 1].size > vehicle.capacity) {
                return StateResult.CapacityExceeded(
                    "Capacity for vehicle ${vehicleId + 1} exceeded. " +
                            "Capacity: ${vehicle.capacity} Size of package: ${world.calls[call - 1].size}"
                )

            } else {
                packs[call - 1] = true
                currentWeight += world.calls[call - 1].size
                currentTravelTime += node.originTime
            }
        }
        currentNode = destinationNode
    }
    return StateResult.Ok("Ok")
}