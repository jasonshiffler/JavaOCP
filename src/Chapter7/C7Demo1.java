/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Creating Threads Directly
 * -Executor Service
 * -Runnable Interface
 *
 *
 */


package Chapter7;

import java.util.concurrent.*;

public class C7Demo1 {


    public static void main(String[] args) {

                                                      //Two ways to create a thread directly,the first
        Thread thread = new Thread(new PrintData());  //provide a runnable object to the thread constructor
        thread.start();                               //go ahead and start the task

        new ReadInventoryThread().start();          //Second way is to extend the Thread class and override
                                                    //the run method

        ExecutorService service = null;             //Executor service is the recommended way to create and manage
                                                     //threads
        try {
            service = Executors.newSingleThreadExecutor();   //Have the factory create the Thread Service
            System.out.println("begin");
            service.execute( ()-> System.out.println("Printing Zoo Inventory") ); //Takes a runnable
            service.execute( ()->{ for(int i = 0; i<50; i++)
                                       System.out.println("Printing record: " + i);
                                  }
                           );
            service.execute(()-> System.out.println("Printing Zoo inventory"));
            System.out.println("end");


        }finally {
            if(service != null)
                service.shutdown(); //Shutdown the thread so the program can terminate
                                     //Executor service does not implement autoclosable
        } //close finally


        //Same code using .submit() instead of .execute(). submit returns a futures object
        //which gives status on the execution of the thread

        try {
            service = Executors.newSingleThreadExecutor();   //Have the factory create the Thread Service
            System.out.println("begin");
            service.submit(() -> System.out.println("Printing Zoo Inventory")); //Takes a runnable
            Future result = service.submit(() -> {
                for (int i = 0; i < 50; i++)
                    System.out.println("Printing record: " + i);
                    }
            );
            service.submit(() -> System.out.println("Printing Zoo inventory"));
            System.out.println("end");
            result.get(10, TimeUnit.SECONDS);            //throws an exception if the result isn't returned in 10s
        }
            catch(TimeoutException e){
                System.out.println("not reached in time!");
            }
        catch(Exception e){

        }

        finally {
            if(service != null)
                service.shutdown(); //Shutdown the thread so the program can terminate
            //Executor service does not implement autoclosable
        } //close finally


    }//close main


} //close class


class PrintData implements Runnable{

    @Override
    public void run() {

        for (int i=0; i<10; i++){
            System.out.println("Printing Record: " + i);

        }
    }
} //close PrintData


class ReadInventoryThread extends Thread{

    public void run() {
        System.out.println("Printing Zoo inventory");

    }
}//close ReadInventoryThread


