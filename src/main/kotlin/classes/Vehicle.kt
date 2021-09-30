package classes

data class Vehicle(
    val id: Int,
    val homeNode: Int,
    val startingTime: Int,
    val capacity: Int,
    var validCalls: MutableList<Int>, // Refers to the index of the call
)
