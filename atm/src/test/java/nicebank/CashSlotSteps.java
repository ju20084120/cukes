package nicebank;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CashSlotSteps {

    private KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper){
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int amount) throws Throwable {
        Assert.assertEquals("Incorrect amount of dispensed cash - ", amount,
                helper.getCashSlot().getContents());
    }
}
