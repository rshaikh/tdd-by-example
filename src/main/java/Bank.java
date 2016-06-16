import java.util.HashMap;
import java.util.Map;

/**
 * Created by pinky on 16/06/16.
 */
public class Bank {

    Map<Pair, Integer> rates = new HashMap<Pair, Integer>();
    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }
}
