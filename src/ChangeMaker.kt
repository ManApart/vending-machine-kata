class ChangeMaker {

    fun makeChange(amount: Int): Map<Coin, Int> {
        val change = mutableMapOf<Coin, Int>()
        var remainingAmount = amount
        while (remainingAmount > 0){
            val largestCoin = findLargestCoin(remainingAmount)
            remainingAmount -= largestCoin.value
            change[largestCoin.coin] = (change[largestCoin.coin] ?: 0) + 1
        }

        return change
    }

    fun findLargestCoin(amount: Int): CoinValue {
        CoinValue.values().sortedByDescending { it.value }.forEach {
            if (it.value <= amount) {
                return it
            }
        }
        throw Throwable("Invalid amount")
    }
}