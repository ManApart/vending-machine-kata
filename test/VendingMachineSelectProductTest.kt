import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineSelectProductTest {
    var machine = VendingMachine()

    @Before
    fun before() {
        machine = VendingMachine()
    }

    @Test
    fun purchaseCola() {
        for (i in 0..3) {
            machine.insertCoin(Coin.QUARTER)
        }
        machine.selectProduct(Product.COLA)

        Assert.assertEquals(Product.COLA, machine.dispensedProduct)
        Assert.assertEquals("THANK YOU", machine.getDisplay())
        Assert.assertEquals("INSERT COIN", machine.getDisplay())
    }

    @Test
    fun colaRequires100CentsAndHasNone() {
        machine.selectProduct(Product.COLA)
        Assert.assertEquals(null, machine.dispensedProduct)
        Assert.assertEquals("PRICE $1.00", machine.getDisplay())
        Assert.assertEquals("INSERT COIN", machine.getDisplay())
    }

    @Test
    fun purchaseChips() {
        machine.insertCoin(Coin.QUARTER)
        machine.insertCoin(Coin.QUARTER)

        machine.selectProduct(Product.CHIPS)

        Assert.assertEquals(Product.CHIPS, machine.dispensedProduct)
        Assert.assertEquals("THANK YOU", machine.getDisplay())
    }


}