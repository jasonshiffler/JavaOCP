/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Callable
 * -Execution Scheduling
 * -Thread Pool
 *
 */



package Chapter7;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

public class C7Demo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService eService= null;

        try{
            eService = Executors.newSingleThreadExecutor();
            Future<Integer> result = eService.submit( ()-> 44  ); //Submit is overloaded and supports a return type
            System.out.println(result.get());                     //in this case we're using the Callable interface
                                                                  //instead of Runnable
        } finally {
            if(eService != null)
                eService.shutdown();
        } //close finally


        //A Scheduled Executor Service allows for tasks to be scheduled in the future.

        ScheduledExecutorService sService = newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello!");
        Callable task2 = () -> "What's up!";


        Future result1 = sService.schedule(task1,5,TimeUnit.SECONDS);
        Future result2 = sService.schedule(task2,10,TimeUnit.SECONDS);
        sService.shutdown();

        //Can use a FixedThreadPool to allow multiple threads to be used for tasks
        eService = Executors.newFixedThreadPool(2);

        eService.submit(task1);
        eService.submit(task2);
        eService.shutdown();



    } //close main

}
