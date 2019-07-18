/**
 * This file illustrates the following concepts from Chapter 3 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Collections (List, Set, Queue)
 * -List - ordered, allows duplicates
 * -Set - not ordered, no duplicates
 * -Queue
 * -Map
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */


package Chapter3;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

import java.util.*;

public class C3Demo2 {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>(); //ArrayList is one possible implementation of the List interface

        System.out.println("****************List*********************");

        list.add("Hello");
        list.add("Goodbye");


        //looping through a list
        for (String item: list)
            System.out.println(item);

        //Another way to iterate through a list
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String string = iter.next();
            System.out.println(string);
        }

        Set<String> set = new HashSet<>(); // A hashset is an implementation of a set

        System.out.println("****************Set*********************");

        System.out.println(set.add("Hello")); //returns true since it added the item
        set.add("Goodbye");
        set.add("Hello");
        set.add("Goodbye");
        System.out.println(set.add("Hello")); //returns false since "Hello" is already part of the set
        set.add("Goodbye");
        set.add("Addios");
        set.add("Hola");
        System.out.println(set); //Will show that there are no duplicate items even though we've tried to add them.


        NavigableSet<Integer> naviSet = new TreeSet<Integer>();

        System.out.println("****************Navigable Set*********************");

        naviSet.add(50);
        naviSet.add(25);
        naviSet.add(75);
        naviSet.add(100);
        naviSet.add(125);
        System.out.println(naviSet.add(125)); //outputs false since this is a set and no duplicates are allowed

        System.out.println(naviSet.lower(200)); //returns the greatest element that is <200

        System.out.println(naviSet.floor(125)); //returns the greatest element that is <=125

        System.out.println(naviSet.ceiling(125)); //returns the greatest element that is >=125

        System.out.println(naviSet.higher(125)); //returns the greatest element that is >125, returns null since
                                                    //there is none

        Queue<Integer> queue = new ArrayDeque<>();  //An ArrayDeque is an implementation of a Queue

        ArrayDeque<Integer> queue2 = (ArrayDeque) queue; //Need this to show push


        System.out.println("****************Queue*********************");
        queue.add(40);
        queue.add(10);
        queue.add(55);                     //Adds element to end of queue and returns true if successful
        queue.add(155);                    //throws exception otherwise
        queue.add(255);
        queue.add(55);                     //Duplicates are ok in a Queue
        System.out.println(queue);

        System.out.println(queue.element()); //Returns the next element in the queue, throws exception if empty queue
        queue.offer(175);                 //Adds element to end of queue and returns true if successful
        queue.remove();                      //removes and returns the next element
        queue.poll();                        //removes and returns next element, returns null if empty
        queue.peek();                        //returns next element, returns null if empty queue

        queue2.push(50);                 //push requires a double ended queue. not part of queue interface
                                            //Adds an item to the beginning of the queue


        /**
         * Different examples of Map implementations
         * HashMap - Doesn't preserve order of insertion but can add and retrieve elements in constant time
         * LinkedMap - Preserve order of insertion.
         * TreeMap - stores keys in a sorted order, adding and checking if a key is present is log n
         *
         * */

        Map<String,Long> map1 = new HashMap<>();
        Map<String,Integer> map2 = new TreeMap<>();
        Map<String,Integer> map3 = new LinkedHashMap<>();


        System.out.println("****************Maps*********************");

        map1.put("Billy", 4049801234L);
        map1.put("Steve", 4049804576L);
        map1.put("Max", 4049809999L);
        map1.put("Barb", 4049800000L);
        map1.put("Dustin", 4049805555L);

        System.out.println("Map size is " + map1.size());
        System.out.println("Is the map empty? " + map1.isEmpty());
        System.out.println("Dustin's phone number is + " + map1.get("Dustin"));
        map1.put("Barb", map1.put("Barb",2220000000L));
        System.out.println("Barb's new number is " + map1.get("Barb"));


    }

}
