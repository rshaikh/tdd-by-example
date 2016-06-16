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
}
