import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by rashid on 17/6/16.
 */
public class DollarTest {

    @Test
    public void it_should_multiply_dollars() throws Exception {
        assertThat(Money.dollar(5).times(2), is(Money.dollar(10)));

        assertThat(Money.dollar(5).times(3), is(Money.dollar(15)));

    }

    @Test
    public void it_should_multiply_francs() throws Exception {
        assertThat(Money.franc(5).times(2), is(Money.franc(10)));

        assertThat(Money.franc(5).times(3), is(Money.franc(15)));

    }

    @Test
    public void it_should_test_equality() throws Exception {
        assertThat(Money.dollar(5), is(Money.dollar(5)));

        assertThat(Money.franc(5), is(not(Money.dollar(5))));

    }

    @Test
    public void it_should_test_currencies() throws Exception {
        assertThat(Money.dollar(5).currency(), is("USD"));
        assertThat(Money.franc(5).currency(), is("CHF"));
    }
}
