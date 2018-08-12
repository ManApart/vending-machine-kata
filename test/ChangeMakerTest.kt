import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChangeMakerTest {
    var changeMaker = ChangeMaker()

    @Before
    fun before(){
        changeMaker = ChangeMaker()
    }

    @Test
    fun findLargestCoinQuarter() {
        val coin = changeMaker.findLargestCoin(50)
        Assert.assertEquals(CoinValue.QUARTER, coin)
    }

    @Test
    fun findLargestCoinPenny() {
        val coin = changeMaker.findLargestCoin(4)
        Assert.assertEquals(CoinValue.PENNY, coin)
    }

    @Test
    fun getChangeFor50() {
        val change = changeMaker.makeChange(50)

        Assert.assertEquals(1, change.entries.size)
        Assert.assertEquals(2, change[Coin.QUARTER])
    }

}