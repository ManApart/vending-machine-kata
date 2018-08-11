import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineSelectProductTest {
    var machine = VendingMachine()

    @Before
    fun before(){
        machine = VendingMachine()
    }

    @Test
    fun purchaseCola(){
        for (i in 0..3){
            machine.insertCoin(Coin.QUARTER)
        }
        machine.selectProduct(Product.COLA)

        Assert.assertEquals(Product.COLA, machine.dispensedProduct )
    }


}