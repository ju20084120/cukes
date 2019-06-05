package nicebank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {

        private Account myAccount;
        private CashSlot cashSlot;
        private Teller automatedTeller;
        private EventFiringWebDriver webDriver;

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

        public Teller getAutomatedTeller(){
            if(automatedTeller == null){
                automatedTeller = new AtmUserInterface();
            }
            return automatedTeller;
        }

        public EventFiringWebDriver getWebDriver(){
            if(webDriver == null){
                webDriver = new EventFiringWebDriver(new FirefoxDriver());
            }
            return webDriver;
        }

}
