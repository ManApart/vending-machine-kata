import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineMakeChangeTest {
    var machine = VendingMachine()

    @Before
    fun before(){
        machine = VendingMachine()
    }

    @Test
    fun changeIsMadeForCola() {
        for (i in 0..5){
            machine.insertCoin(Coin.QUARTER)
        }

        machine.selectProduct(Product.COLA)

        Assert.assertEquals(2, machine.coinsReturn[Coin.QUARTER])
    }


}