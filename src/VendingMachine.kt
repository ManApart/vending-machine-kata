class VendingMachine {
    private val coins = mutableMapOf<Coin, Int>()
    val coinsReturn = mutableMapOf<Coin, Int>()
    var dispensedProduct: Product? = null

    fun insertCoin(coin: Coin) {
        if (coin == Coin.PENNY) {
            coinsReturn[coin] = (coinsReturn[coin] ?: 0) + 1
        } else {
            coins[coin] = (coins[coin] ?: 0) + 1
        }
    }

    fun getDisplay(): String {
        return if (coins.isEmpty()) {
            "INSERT COIN"
        } else {
            formatAmount(calculateAmount())
        }
    }

    fun selectProduct(product: Product) {
        dispensedProduct = product
    }

    private fun calculateAmount(): Int {
        var amount = 0
        coins.forEach {
            val worth = CoinValue.getValue(it.key).value
            amount += it.value * worth
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