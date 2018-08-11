class VendingMachine {
    private val coins = mutableMapOf<Coin, Int>()
    val coinsReturn = mutableMapOf<Coin, Int>()
    var dispensedProduct: Product? = null
    private var showThankYou = false
    private var expensiveProduct: Product? = null

    fun insertCoin(coin: Coin) {
        if (coin == Coin.PENNY) {
            coinsReturn[coin] = (coinsReturn[coin] ?: 0) + 1
        } else {
            coins[coin] = (coins[coin] ?: 0) + 1
        }
    }

    fun getDisplay(): String {
        return when {
            showThankYou -> {
                showThankYou = false
                coins.clear()
                "THANK YOU"
            }
            expensiveProduct != null -> {
                val amount = formatAmount(expensiveProduct!!.price)
                expensiveProduct = null
                "PRICE $amount"
            }
            coins.isEmpty() -> "INSERT COIN"
            else -> formatAmount(calculateAmount())
        }
    }

    fun selectProduct(product: Product) {
        if (calculateAmount() >= product.price){
            dispensedProduct = product
            showThankYou = true
        } else {
            expensiveProduct = product
        }
    }

    fun returnCoins() {
        coins.entries.forEach {
            coinsReturn[it.key] = it.value
        }
        coins.clear()
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
                val centString = if (cents < 10) "0$cents" else "$cents"
                val dollars = amount / 100
                "$$dollars.$centString"
            }
        }
    }
}