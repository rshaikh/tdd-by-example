import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by pinky on 16/06/16.
 */
public class MoneyTest {

    @Test
    public void it_should_test_multiplication() {
        Money fiveDollar = Money.dollar(5);

        assertThat(fiveDollar.times(2), is(Money.dollar(10)));
        assertThat(fiveDollar.times(3), is(Money.dollar(15)));
    }

    @Test
    public void it_should_test_multiplication_for_Franc() {
        Money fiveFrancs = Money.franc(5);

        assertThat(fiveFrancs.times(2), is(Money.franc(10)));
        assertThat(fiveFrancs.times(3), is(Money.franc(15)));
    }

    @Test
    public void it_should_give_correct_currencies() {
        assertThat(Money.dollar(10).currency(), is("USD"));
        assertThat(Money.franc(10).currency(), is("CHF"));
    }

    @Test
    public void test_equality() {
        assertThat(Money.dollar(10), is(Money.dollar(10)));
        assertThat(Money.dollar(10), is(not(Money.franc(10))));
    }

    @Test
    public void it_should_do_simple_addition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced, is(Money.dollar(10)));
    }

    @Test
    public void plus_should_return_a_sum_expression() {
        Sum sum = (Sum) Money.dollar(10).plus(Money.dollar(15));
        assertThat(sum.moneyOne, is(Money.dollar(10)));
        assertThat(sum.moneyTwo, is(Money.dollar(15)));
    }

    @Test
    public void bank_should_reduce_money_to_itself() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    public void bank_should_add_different_currencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money reduced = bank.reduce(Money.franc(10), "USD");
        assertThat(reduced, is(Money.dollar(5)));
    }

    @Test
    public void it_should_add_different_currencies() {
        Money fiveBucks= Money.dollar(5);
        Money tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(result, is(Money.dollar(10)));
    }

    /*@Test
    public void plus_on_expressions() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(result, is(Money.dollar(10)));
    }*/
}
