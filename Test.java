package enterprise2;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List<Task<Long>> list = new ArrayList<>();
        list.add(new LongTask(100L));
        list.add(new LongTask(200L));
        list.add(new LongTask(300L));

        Test test = new Test();
        test.test(list);
    }

    public void test(List <Task <Long> > longTasks) {
        Executor<Long> numberExecutor = new ExecutorImpl<> ();

        for (Task<Long> intTask : longTasks) {
            numberExecutor.addTask(intTask, new NumberValidator());
        }
        numberExecutor.addTask(new LongTask(400L));

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }


}


