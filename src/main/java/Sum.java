/**
 * Created by rashid on 16/6/16.
 */
public class Sum implements Expression{
    public Expression moneyOne;
    public Expression moneyTwo;

    public Sum(Expression moneyOne, Expression moneyTwo) {
        this.moneyOne = moneyOne;
        this.moneyTwo = moneyTwo;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = moneyOne.reduce(bank, to).amount + moneyTwo.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression anotherMoney) {
        return new Sum(this, anotherMoney);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(moneyOne.times(multiplier), moneyTwo.times(multiplier));
    }
}
