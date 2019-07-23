/**
 * This file illustrates the following concepts from Chapter 5 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Lambda Expressions
 * -Functional Interfaces
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 *
 */

package Chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class C4Demo1 {


    public static void main(String[] args) {

        //Initialize a new List of Animals

        List<Animal>  animals = Arrays.asList(new Animal(75,"goat","Billy"),
                                              new Animal(90,"deer","Bambi"),
                                              new Animal(800,"cattle","Ferdinand"));

        // Print out the whole list
        printConditional(animals,(a)->true,(a) -> System.out.println(a.getName()));


        //Sort the list, Comparator is a functional interface so we can pass in a Lambda Expression
        Collections.sort(animals,(Animal a1, Animal a2)-> a1.getName().compareTo(a2.getName()) );

        // Print out the whole list
        printConditional(animals,(a)->true,(a) -> System.out.println(a.getName()));

        //print out any animals whose weight is over 80
        printConditional(animals,(a)-> a.getWeight() > 80, (a) -> System.out.println(a.getName()));

    }

    /**
     * Predicate and Consumer are convenience Functional Interfaces so we don't have to create our own
     * Method allows us to perform a test on an animal list and perform some action based on the result of the
     * test. Allows us to write much more reusable code.
     */

    static void printConditional(List<Animal> animals, Predicate<Animal> predicate,
                                 Consumer<Animal> consumer){

        for (Animal a : animals)
            if (predicate.test(a))
                consumer.accept(a);
    }

    /**
     *Showing how we could define the same method using our own interfaces
     *
     */
    static void printConditional2(List<Animal> animals, Condition<Animal> condition, Execute<Animal> execute){

        for (Animal a : animals)
            if (condition.tester(a))
                execute.execute(a);
    }


    //We annotate these as functional interfaces so that someone else doesn't
    //unwittingly add another abstract method. A functional interface can only
    //have one abstract method
@FunctionalInterface
    interface Condition<T>{
        public boolean tester(T t);
        //public int breaker(T t);// Adding another abstract method breaks the functional interface

    }
@FunctionalInterface
    interface Execute<T>{
        public void execute(T t);

    }


}


