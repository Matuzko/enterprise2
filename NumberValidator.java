package enterprise2;


public class NumberValidator implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        if (result.intValue() > 0) {
            return true;
        } else if (result.doubleValue() > 0) {
            return true;
        } else if (result.longValue() > 0) {
            return true;
        }
        return false;
    }
}
