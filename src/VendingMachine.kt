class VendingMachine {
    var coins = mutableMapOf<Coin, Int>()

    fun insertCoin(coin: Coin) {
        coins[coin] = (coins[coin] ?: 0) + 1
    }

    fun getDisplay(): String {
        return if (coins.isEmpty()) {
            "INSERT COIN"
        } else {
            var amount = 0
            coins.forEach {
                amount += it.value * 5
            }
            if (amount < 10) {
                "$0.0$amount"
            } else {
                "$0.$amount"
            }
        }
    }
}