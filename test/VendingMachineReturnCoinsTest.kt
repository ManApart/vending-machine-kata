import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineReturnCoinsTest {
    var machine = VendingMachine()

    @Before
    fun before(){
        machine = VendingMachine()
    }

    @Test
    fun coinsAreReturned() {
        machine.insertCoin(Coin.QUARTER)
        machine.insertCoin(Coin.QUARTER)
        machine.insertCoin(Coin.DIME)
        machine.insertCoin(Coin.NICKEL)

        machine.returnCoins()

        Assert.assertEquals(2, machine.coinsReturn[Coin.QUARTER])
        Assert.assertEquals(1, machine.coinsReturn[Coin.DIME])
        Assert.assertEquals(1, machine.coinsReturn[Coin.NICKEL])
        Assert.assertEquals("INSERT COIN", machine.getDisplay())
    }


}