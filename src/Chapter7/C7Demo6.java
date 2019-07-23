/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 *  Fork Join Pool
 *
 */

package Chapter7;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class C7Demo6 {

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> task = new WeighAnimal(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }



}


class WeighAnimal extends RecursiveAction {

    int start;
    int end;
    Double[] weights;

    WeighAnimal(Double[] weights, int start, int end){

        this.start = start;
        this.end = end;
        this.weights = weights;
    }



    protected void compute(){

        if(end-start <= 3) {
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
            }
        }
        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimal(weights,start,middle),new WeighAnimal(weights,middle,end));

        }


    }



}