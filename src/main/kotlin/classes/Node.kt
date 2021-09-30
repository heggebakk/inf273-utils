package classes

data class Node(
    val vehicleId: Int,
    val callId: Int,
    val originTime: Int,
    val originCost: Int,
    val destinationTime: Int,
    val destinationCost: Int
)
