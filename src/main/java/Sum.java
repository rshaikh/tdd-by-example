/**
 * Created by rashid on 16/6/16.
 */
public class Sum implements Expression{
    public Money moneyOne;
    public Money moneyTwo;

    public Sum(Money moneyOne, Money moneyTwo) {
        this.moneyOne = moneyOne;
        this.moneyTwo = moneyTwo;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = moneyOne.reduce(bank, to).amount + moneyTwo.reduce(bank, to).amount;
        return new Money(amount, to);
    }
}
