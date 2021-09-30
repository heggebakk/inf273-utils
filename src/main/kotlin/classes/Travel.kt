package classes

data class Travel(
    val vehicleId: Int,
    val originNode: Int,
    val destinationNode: Int,
    val travelTime: Int,
    val travelCost: Int
)