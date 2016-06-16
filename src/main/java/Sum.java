/**
 * Created by pinky on 16/06/16.
 */
public class Sum implements Expression {
    Expression moneyOne;
    Expression moneyTwo;

    public Sum(Expression moneyOne, Expression moneyTwo) {
        this.moneyOne = moneyOne;
        this.moneyTwo = moneyTwo;
    }

    public Money reduce(Bank bank, String to) {
        int amount = bank.reduce(moneyOne, to).amount + bank.reduce(moneyTwo, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression anotherMoney) {
        return new Sum(this, anotherMoney);
    }

    @Override
    public Expression times(int multiplier) {
        return moneyOne.times(multiplier).plus(moneyTwo.times(multiplier));
    }
}
