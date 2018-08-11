class VendingMachine {
    var coins = mutableMapOf<Coin, Int>()

    fun insertCoin(coin: Coin) {
        coins[coin] = (coins[coin] ?: 0) + 1
    }

    fun getDisplay(): String {
        return if (coins.isEmpty()) {
            "INSERT COIN"
        } else {
            formatAmount(calculateAmount())
        }
    }

    private fun calculateAmount(): Int {
        var amount = 0
        coins.forEach {
            amount += it.value * 5
        }
        return amount
    }

    private fun formatAmount(amount: Int): String {
        return when {
            amount < 10 -> "$0.0$amount"
            amount < 100 -> "$0.$amount"
            else -> {
                val cents = amount % 100
                val dollars = amount / 100
                "$$dollars.$cents"
            }
        }
    }
}