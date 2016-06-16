/**
 * Created by rashid on 15/6/16.
 */
public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;

        return amount == money.amount && currency.equals(money.currency);

    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + "" + currency;
    }

    @Override
    public Expression plus(Expression anotherMoney) {
        return new Sum(this, anotherMoney);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
