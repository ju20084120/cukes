package nicebank;

public class Account {

    private TransactionQueue queue = new TransactionQueue();
    private Money balance = new Money();

    public void credit(Money amount){
        queue.write("+" + amount.toString());
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
