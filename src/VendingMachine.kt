class VendingMachine {
    var hasCoins = false

    fun insertCoin(coin: Coin) {
        hasCoins = true
    }

    fun getDisplay() : String {
        return if (hasCoins) "$0.05" else "INSERT COIN"
    }
}