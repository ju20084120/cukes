package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tarnsforms.MoneyConverter;

public class Steps {

    private KnowsTheDomain helper;

    public Steps(){
        helper = new KnowsTheDomain();
    }

    class KnowsTheDomain{
        private Account myAccount;
        private CashSlot cashSlot;
        private Teller teller;

        public Account getMyAccount() {
            if(myAccount == null){
                myAccount = new Account();
            }
            return myAccount;
        }

        public CashSlot getCashSlot(){
            if(cashSlot == null){
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }

        public Teller getTeller(){
            if(teller == null){
                teller = new Teller(helper.getCashSlot());
            }
            return teller;
        }
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable{
        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("Incorrect account balance - ", amount,
                helper.getMyAccount().getBalance());
    }

    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int amount) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int amount) throws Throwable {
        Assert.assertEquals("Incorrect amount of dispensed cash - ", amount,
                helper.getCashSlot().getContents());
    }


}
