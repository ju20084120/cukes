package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tarnsforms.MoneyConverter;

public class Steps {

    class Account {

        private Money balance = new Money();

        public void deposit(Money openingBalance){
            balance = balance.add(openingBalance);
        }

        public Money getBalance(){
            return balance;
        }
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable{
        Account myAccount = new Account();
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance - ", amount, myAccount.getBalance());
    }

    @When("^I request \\$(\\d+)$")
    public void i_request_$(int amount) throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
