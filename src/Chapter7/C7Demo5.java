/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * Parallel Streams
 *
 *
 *
 */

package Chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class C7Demo5 {

    public static void main(String[] args) {

        //Two ways to create a parallel stream


        //Take a stream and convert to a parallel stream
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6,7).stream();
        Stream<Integer> parallelStream = stream.parallel();

        //or create one directly
        Stream<Integer> pstream = Arrays.asList(1,2,3,4,5,6,7).parallelStream();

        DataCalc dCalc = new DataCalc();

        List<Integer> data = new ArrayList<>();

        for(int i = 0; i<4000; i++)
            data.add(i);

        long start = System.currentTimeMillis();
        //dCalc.processAllData(data);
        dCalc.processAllDataParallel(data);
        double time = (System.currentTimeMillis()-start);

        System.out.println("Completed in: "+time+ " milli seconds");

    }

}


class DataCalc{

    public int processRecord(int input){

        input += 1;
        input += 2;
        input += 1;
        input += 1;
        input -= 1;
        input -= 1;

        return input + 1;

    }

    //Two options for methods that run a stream. One has runs multithreaded and the other doesn't

    public void processAllData(List<Integer> data){
        data.stream().map(a -> processRecord(a)).count();

    }

    public void processAllDataParallel(List<Integer> data){
        data.parallelStream().map(a -> processRecord(a)).count();

    }

}