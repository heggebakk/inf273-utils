package classes

data class Call(
    val index: Int,
    val originNode: Int,
    val destinationNode: Int,
    val size: Int,
    val costNotTransport: Int,
    val pickupLowerTW: Int,
    val pickupUpperTW: Int,
    val deliverLowerTW: Int,
    val deliverUpperTW: Int
)
