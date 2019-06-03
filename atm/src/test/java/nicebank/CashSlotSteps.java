package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import tarnsforms.MoneyConverter;

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

    public static class AccountSteps {
        KnowsTheDomain helper;

        public AccountSteps(KnowsTheDomain helper) {
            this.helper = helper;
        }

        @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
        public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable{
            helper.getMyAccount().credit(amount);
        }

        @And("^the balance of my account should be (\\$\\d+\\.\\d+)$")
        public void the_balance_of_my_account_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable{
            Assert.assertEquals("Incorrect account balance - ", amount,
                    helper.getMyAccount().getBalance());
        }
    }
}
