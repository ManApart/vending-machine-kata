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

    @Test
    fun accept2Nickels(){
        machine.insertCoin(Coin.NICKEL)
        machine.insertCoin(Coin.NICKEL)
        Assert.assertEquals("$0.10", machine.getDisplay())
    }

    @Test
    fun accept22Nickels(){
        for (i in 0 until 22){
            machine.insertCoin(Coin.NICKEL)
        }
        Assert.assertEquals("$1.10", machine.getDisplay())
    }

}