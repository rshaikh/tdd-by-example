/**
 * Created by rashid on 15/6/16.
 */
public class Franc extends Money{

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier, currency);
    }

}
