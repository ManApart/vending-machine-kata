import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineAcceptCoinsTest {
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
    fun rejectPenny(){
        machine.insertCoin(Coin.PENNY)
        Assert.assertEquals("INSERT COIN", machine.getDisplay())
        Assert.assertEquals(1, machine.coinsReturn[Coin.PENNY])
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

    @Test
    fun acceptDime(){
        machine.insertCoin(Coin.DIME)
        Assert.assertEquals("$0.10", machine.getDisplay())
    }

    @Test
    fun acceptQuarter(){
        machine.insertCoin(Coin.QUARTER)
        Assert.assertEquals("$0.25", machine.getDisplay())
    }

}