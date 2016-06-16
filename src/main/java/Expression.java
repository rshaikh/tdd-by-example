/**
 * Created by pinky on 16/06/16.
 */
public interface Expression {
    public Money reduce(Bank bank, String to);

    Expression plus(Expression anotherMoney);


    Expression times(int multiplier);
}
