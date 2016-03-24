package enterprise2;

import java.util.List;


public interface Executor <T>{

    void addTask (Task <? extends T> task);

    void addTask(Task<? extends T> task, Validator validator);

    void execute ();

    List <T> getValidResults ();

    List <T> getInvalidResults ();
}
