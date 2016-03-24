package enterprise2;

/**
 * Created by Дима on 23.03.2016.
 */
public interface Validator <T> {
    boolean isValid (T result);
}
