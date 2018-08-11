enum class CoinValue(val coin: Coin, val value: Int) {
    NICKEL(Coin.NICKEL, 5),
    DIME(Coin.DIME, 10),
    QUARTER(Coin.QUARTER, 25);

    companion object {
        fun getValue(coin: Coin) : CoinValue {
            return CoinValue.values().first { it.coin == coin }
        }
    }
}
