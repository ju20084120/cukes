package nicebank;

public class KnowsTheDomain {

        private Account myAccount;
        private CashSlot cashSlot;
        private Teller automatedTeller;

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

}
