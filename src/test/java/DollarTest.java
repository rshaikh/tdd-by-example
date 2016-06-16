import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by rashid on 15/6/16.
 */
public class DollarTest {
    @Test
    public void testEquality() throws Exception {
        assertThat(Money.dollar(5), is(Money.dollar(5)));
        assertThat(Money.franc(5), not(Money.franc(6)));
        assertThat(Money.franc(5), not(Money.dollar(5)));
    }

    @Test
    public void testTimesMoney() {
        Money dollar = Money.dollar(5);
        assertThat(dollar.times(2), is(Money.dollar(10)));
    }

    @Test
    public void testCurrency() {
        assertThat(Money.dollar(1).currency(), is("USD"));
        assertThat(Money.franc(1).currency(), is("CHF"));
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced, is(Money.dollar(10)));
    }

    @Test
    public void testPlusReturnsSum() {
        Money five= Money.dollar(5);
        Expression result= five.plus(five);
        Sum sum = (Sum) result;
        assertThat(five, is(sum.moneyOne));
        assertThat(five, is(sum.moneyTwo));
    }

    @Test
    public void testReduceSum() {
        Expression sum= new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank= new Bank();
        Money result= bank.reduce(sum, "USD");
        assertThat(result, is(Money.dollar(7)));
    }

    @Test
    public void testReduceMoney() {
        Bank bank= new Bank();
        Money result= bank.reduce(Money.dollar(1), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    public void testIdentityRate(){
        Bank bank = new Bank();
        assertThat(bank.rate("USD", "USD"), is(1));
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(Money.franc(2), "USD");
        assertThat(result, is(Money.dollar(1)));
    }
}
