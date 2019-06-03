package nicebank;

import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import tarnsforms.MoneyConverter;


public class AccountSteps {
    KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable{
        helper.getMyAccount().deposit(amount);
    }

    @And("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void the_balance_of_my_account_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable{
        Assert.assertEquals("Incorrect account balance - ", amount,
                helper.getMyAccount().getBalance());
    }
}
