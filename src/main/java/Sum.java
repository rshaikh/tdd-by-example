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
    public Money reduce(String to) {
        return new Money(moneyOne.amount + moneyTwo.amount, to);
    }
}
