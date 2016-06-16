/**
 * Created by pinky on 16/06/16.
 */
public class Sum implements Expression {
    Money moneyOne;
    Money moneyTwo;

    public Sum(Money moneyOne, Money moneyTwo) {
        this.moneyOne = moneyOne;
        this.moneyTwo = moneyTwo;
    }

    public Money reduce(Bank bank, String to) {
        int amount = bank.reduce(moneyOne, to).amount + bank.reduce(moneyTwo, to).amount;
        return new Money(amount, to);
    }
}
