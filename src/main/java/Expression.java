/**
 * Created by rashid on 16/6/16.
 */
public interface Expression {
    Money reduce(Bank bank, String to);
}