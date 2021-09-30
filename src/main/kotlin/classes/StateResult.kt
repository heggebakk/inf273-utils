package classes

sealed class StateResult() {
    abstract val message: String
    class Ok(override val message: String) : StateResult()
    class InvalidCall(override val message: String): StateResult()
    class CapacityExceeded(override val message: String): StateResult()
    class TimeWindowExceeded(override val message: String) : StateResult()
    class PackagesNotDelivered(override val message: String) : StateResult() {

    }

    fun isOk(): Boolean = this::class == Ok::class
}

