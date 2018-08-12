class VendingMachine {
    private val productStock = mutableMapOf(Pair(Product.COLA, 2), Pair(Product.CHIPS, 2), Pair(Product.CANDY, 2))
    private val coins = mutableMapOf<Coin, Int>()
    val coinsReturn = mutableMapOf<Coin, Int>()
    var dispensedProduct: Product? = null
    var vendingState = VendingState.VENDING
    private var expensiveProduct: Product? = null
    private val changeMaker = ChangeMaker()

    fun insertCoin(coin: Coin) {
        if (coin == Coin.PENNY) {
            coinsReturn[coin] = (coinsReturn[coin] ?: 0) + 1
        } else {
            coins[coin] = (coins[coin] ?: 0) + 1
        }
    }

    fun getDisplay(): String {
        return when(vendingState) {
            VendingState.SOLD_OUT ->{
                vendingState = VendingState.VENDING
                "SOLD OUT"
            }
            VendingState.EXACT_CHANGE_ONLY ->{
                "EXACT CHANGE ONLY"
            }
            VendingState.PURCHASE_COMPLETE ->{
                vendingState = VendingState.VENDING
                "THANK YOU"
            }
            VendingState.NOT_ENOUGH_MONEY ->{
                val amount = formatAmount(expensiveProduct!!.price)
                expensiveProduct = null
                vendingState = VendingState.VENDING
                "PRICE $amount"
            }
            else -> {
                if (coins.isEmpty()) {
                    "INSERT COIN"
                } else {
                    formatAmount(calculateAmount())
                }
            }
        }
    }

    fun selectProduct(product: Product) {
        val stockCount = productStock[product] ?: 0
        if (stockCount > 0) {
            if (calculateAmount() >= product.price) {
                dispensedProduct = product
                makeChange(product)
                coins.clear()
                productStock[product] = (productStock[product] ?: 0) -1
                vendingState = VendingState.PURCHASE_COMPLETE
            } else {
                expensiveProduct = product
                vendingState = VendingState.NOT_ENOUGH_MONEY
            }
        } else {
            vendingState = VendingState.SOLD_OUT
        }
    }

    private fun makeChange(product: Product) {
        val change = changeMaker.makeChange(calculateAmount() - product.price)
        change.entries.forEach {
            coinsReturn[it.key] = (coinsReturn[it.key] ?: 0) + it.value
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