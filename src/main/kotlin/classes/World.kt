package classes

data class World(
    val vehicles: List<Vehicle>,
    val nodes: List<Node>,
    val calls: List<Call>,
    val travels: Array<Array<Travel>>,
    val numNodes: Int,
) {
    var isFeasible = true

    fun findTravel(vehicleId: Int, currentNode: Int, destinationNode: Int): Travel {
        return travels[vehicleId][currentNode * numNodes + destinationNode]
    }

    fun findNode(vehicleId: Int, call: Int): Node {
        return nodes[vehicleId * calls.size + call]
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as World

        if (vehicles != other.vehicles) return false
        if (nodes != other.nodes) return false
        if (calls != other.calls) return false
        if (!travels.contentDeepEquals(other.travels)) return false
        if (numNodes != other.numNodes) return false
        if (isFeasible != other.isFeasible) return false

        return true
    }

    override fun hashCode(): Int {
        var result = vehicles.hashCode()
        result = 31 * result + nodes.hashCode()
        result = 31 * result + calls.hashCode()
        result = 31 * result + travels.contentDeepHashCode()
        result = 31 * result + numNodes
        result = 31 * result + isFeasible.hashCode()
        return result
    }
}
