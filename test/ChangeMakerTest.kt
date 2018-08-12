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

}