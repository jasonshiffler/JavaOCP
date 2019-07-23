/**
 * This file illustrates the following concepts from Chapter 7 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 *  Threadsafe Collections
 *
 */

package Chapter7;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class C7Demo4 {


    public static void main(String[] args) {

        ExecutorService service = null;
        MapExample mapEx = new MapExample();

        Instant t1, t2;

        t1 = Instant.now();

        try{
            service = Executors.newFixedThreadPool(1);       //have a threadpool object created


            for(int i = 0; i < 10000; i++)
                service.submit(() -> mapEx.addItem()); //add an item to the map

        } finally {
            if(service != null)
                service.shutdown();                            //shutdown the service
        }// close finally

        t2 = Instant.now();
        String sMap = mapEx.convertWithStream();
        System.out.println(sMap);
        System.out.println(Duration.between(t1,t2));


    }
}

class MapExample {

    private Map<Double,Double> map = new ConcurrentHashMap<>();


    void addItem(){

        Double key = Math.random();
        Double value = Math.random();
        map.put(key,value);
    }

    public String convertWithStream() {
        String mapAsString = this.map.keySet().stream()
                .map(key -> key + "=" + this.map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;

    }
}
