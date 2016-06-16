/**
 * Created by rashid on 15/6/16.
 */
public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    abstract Money times(int amount);

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;

        return amount == money.amount && getClass().equals(o.getClass());

    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public String currency() {
        return currency;
    }
}
