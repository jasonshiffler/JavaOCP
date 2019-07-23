/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 *  Atomic Classes
 *  Synchronized methods and blocks
 */

package Chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class C7Demo3 {


    public static void main(String[] args) throws InterruptedException{

        ExecutorService service = null;

        try{
            service = Executors.newFixedThreadPool(4);       //have a threadpool object created
            SheepManager manager = new SheepManager();

            for(int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport()); //increment the number of sheep

        } finally {
            if(service != null)
                service.shutdown();                            //shutdown the service
        }// close finally

        /*
         * Showing another way to do this with synchronized methods
         */

        Thread.sleep(2); // Pause so our output doesn't get tangled

        System.out.println("");
        System.out.println("*******Next Section************");

        try{
            service = Executors.newFixedThreadPool(4);       //have a threadpool object created
            SheepManager manager = new SheepManager();

            for(int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport2()); //increment the number of sheep

        } finally {
            if(service != null)
                service.shutdown();                            //shutdown the service
        }// close finally


    }
}

class SheepManager {

    private AtomicInteger sheepCount = new AtomicInteger(0);     //Members of the Atomic class are thread safe
                                                                    //so that multiple threads can't access the same
                                                                    //data at the same time

    private int sheepCount2 = 0; //This is used for the synchronized demonstration

    void incrementAndReport(){
        System.out.print(sheepCount.incrementAndGet()+" ");

    }

    //Synchronized effectively creates a lock so that only one thread can access the method at once.
    //This sacrifices performance for data integrity and order of operation

    synchronized void incrementAndReport2(){
        System.out.print((++sheepCount2) + " ");

        // If we didn't want to synchronize the whole method we could have done this

        /*
        synchronized (this){
            System.out.print((++sheepCount2) + " ");
        }*/

    }


}
