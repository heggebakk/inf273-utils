package utils

import classes.*
import java.io.File

fun parseInput(filename: String): World {
    val vehicles = emptyList<Vehicle>().toMutableList()
    val callInfo = emptyList<Call>().toMutableList()
    val travelTimeCosts = emptyList<MutableList<Travel>>().toMutableList()
    val nodeTimeCosts = emptyList<Node>().toMutableList()
    val lines = File(filename).readLines().iterator()

    // % number of nodes
    lines.next()
    val numNodes: Int = lines.next().toInt()

    // %  number of vehicles
    lines.next()
    val numVehicles: Int = lines.next().toInt()

    // %  for each vehicle: vehicle index, home node, starting time, capacity
    lines.next()
    for (i in 0 until numVehicles) {
        val vehicle = lines.next().split(',').map { it.toInt() }
        vehicles.add(Vehicle(vehicle[0] - 1, vehicle[1] - 1, vehicle[2], vehicle[3], emptyList<Int>().toMutableList()))
    }

    // % number of calls
    lines.next()
    val numCalls: Int = lines.next().toInt()

    // %  for each vehicle, vehicle index, and then a list of calls that can be transported using that vehicle
    lines.next()
    for (i in 0 until numVehicles) {
        val line = lines.next().split(',').map { it.toInt() - 1 }
        vehicles[line[0]].validCalls = line.drop(1).toMutableList()
    }

    // % for each call: call index, origin node, destination node, size, cost of not transporting,
    // lowerbound timewindow for pickup, upper_timewindow for pickup, lowerbound timewindow for delivery,
    // upper_timewindow for delivery
    lines.next()
    for (i in 0 until numCalls) {
        val call = lines.next().split(',').map { it.toInt() }
        callInfo.add(Call(call[0] - 1, call[1] - 1, call[2] - 1, call[3], call[4], call[5], call[6], call[7], call[8]))
    }

    // %  travel times and costs: vehicle, origin node, destination node, travel time (in hours), travel cost (in )
    lines.next()
    for (i in 0 until vehicles.size) {
        travelTimeCosts.add(emptyList<Travel>().toMutableList())
    }
    for (i in 0 until numVehicles * numNodes * numNodes) {
        val travel = lines.next().split(',').map { it.toInt() }
        val origin = travel[1] - 1
        val destination = travel[2] - 1
        travelTimeCosts[travel[0] - 1].add(origin * numNodes + destination, Travel(travel[0] - 1, travel[1] - 1, travel[2] - 1, travel[3], travel[4]))
    }
    // %  node times and costs: vehicle, call, origin node time (in hours), origin node costs (in ),
    // destination node time (in hours), destination node costs (in )
    lines.next()
    for (i in 0 until numVehicles * numCalls) {
        val node = lines.next().split(',').map { it.toInt() }
        nodeTimeCosts.add((node[0] - 1) * numCalls + (node[1] - 1), Node(node[0] - 1, node[1] - 1, node[2], node[3], node[4], node[5]))
    }

    return World(vehicles, nodeTimeCosts, callInfo, travelTimeCosts.map { it.toTypedArray() }.toTypedArray(), numNodes)
}