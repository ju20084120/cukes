package nicebank;

public class Account {

    private Money balance = new Money();

    public void credit(Money amount){
        balance = balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }

    public void debit(int dollars) {
        Money amount = new Money(dollars, 0);
        balance = balance.minus(amount);
    }
}
