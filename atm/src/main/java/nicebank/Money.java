package nicebank;

public class Money {

    private int dollars;
    private int cents;

    public Money(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money(){
        this.dollars = 0;
        this.cents = 0;
    }

    public int dollars(){
        return dollars;
    }

    public int cents(){
        return cents;
    }

    @Override
    public boolean equals(Object other){
        boolean equal = false;

        if(other instanceof Money){
            Money otherMoney = (Money) other;
            equal = (this.dollars() == otherMoney.dollars() &&
                    this.cents() == otherMoney.cents());
        }

        return equal;
    }

    @Override
    public String toString(){
        return String.format("$%01d.%02d", this.dollars(), this.cents());
    }

    public Money add(Money amount){
        int newCents = this.cents() + amount.cents();
        int newDollars = this.dollars() + amount.dollars();

        if(newCents >= 100){
            newCents -= 100;
            newDollars++;
        }

        return new Money(newDollars, newCents);
    }

    public Money minus(Money amount){
        int newCents = this.cents() - amount.cents();
        int newDollars = this.dollars() - amount.dollars();

        if(newCents < 0){
            newCents += 100;
            newDollars--;
        }

        return new Money(newDollars, newCents);
    }
}