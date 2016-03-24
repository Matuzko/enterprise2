package enterprise2;


public class LongTask implements Task <Long> {
    Long number;
    Long result;

    public LongTask(Long number) {
        this.number = number;
    }

    @Override
    public Long getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = number * number;

    }
}
