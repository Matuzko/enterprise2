package enterprise2;

import java.util.ArrayList;
import java.util.List;


public class ExecutorImpl <T> implements Executor  {

    List<Task<T>> listTask = new ArrayList<Task<T>>() ;
    List <Validator> validators = new ArrayList<Validator>() ;

    List <T> invalidResults = new ArrayList<>();
    List <T> validResults = new ArrayList<>();


    @Override
    public void addTask(Task task) {
        listTask.add(task);
        validators.add(null);
    }

    @Override
    public void addTask(Task task, Validator validator) {
        listTask.add(task);
        validators.add(validator);

    }

    @Override
    public void execute() {
        for (int i = 0; i < listTask.size(); i++) {

            Task<T> task = listTask.get(i);
            task.execute();
            Validator validator = validators.get(i);

            if (validator != null) {
                if (validator.isValid(task.getResult())) {
                    validResults.add(task.getResult());
                } else {
                    invalidResults.add(task.getResult());
                }
            } else {
                invalidResults.add(task.getResult());
            }
        }
    }

    @Override
    public List <T> getValidResults() {
        return validResults;
    }

    @Override
    public List <T> getInvalidResults() {
        return invalidResults;
    }
}
