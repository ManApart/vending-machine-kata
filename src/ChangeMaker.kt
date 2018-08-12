class ChangeMaker {

    fun findLargestCoin(amount: Int): CoinValue {
        CoinValue.values().sortedByDescending { it.value }.forEach {
            if (it.value <= amount) {
                return it
            }
        }
        throw Throwable("Invalid amount")
    }
}