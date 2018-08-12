import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VendingMachineExactChangeTest {
    var machine = VendingMachine()

    @Before
    fun before(){
        machine = VendingMachine()
    }

    @Test
    fun exactChangeOnlyDisplays() {
        machine.vendingState = VendingState.EXACT_CHANGE_ONLY

        Assert.assertEquals("EXACT CHANGE ONLY", machine.getDisplay())
    }


}