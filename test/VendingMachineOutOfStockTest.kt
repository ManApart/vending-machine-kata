import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineOutOfStockTest {
    var machine = VendingMachine()

    @Before
    fun before() {
        machine = VendingMachine()
    }

    @Test
    fun noCoinsReturnsStartMessage(){

        purchaseCola()
        Assert.assertEquals(Product.COLA, machine.dispensedProduct)
        machine.dispensedProduct = null

        purchaseCola()
        Assert.assertEquals(Product.COLA, machine.dispensedProduct)
        machine.dispensedProduct = null

        purchaseCola()
        Assert.assertNull(machine.dispensedProduct)
        Assert.assertEquals("SOLD OUT", machine.getDisplay())
    }

    private fun purchaseCola() {
        for (i in 0 until 4) {
            machine.insertCoin(Coin.QUARTER)
        }
        machine.selectProduct(Product.COLA)
    }



}