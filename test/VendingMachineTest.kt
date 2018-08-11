import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineTest {
    var machine = VendingMachine()

    @Before
    fun before(){
        machine = VendingMachine()
    }

    @Test
    fun noCoinsReturnsStartMessage(){
        Assert.assertEquals("INSERT COIN", machine.getDisplay())
    }

    @Test
    fun acceptNickel(){
        machine.insertCoin(Coin.NICKEL)
        Assert.assertEquals("$0.05", machine.getDisplay())
    }

}