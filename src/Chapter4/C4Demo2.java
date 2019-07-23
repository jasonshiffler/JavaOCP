/**
 * This file illustrates the following concepts from Chapter 5 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Streams
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 *
 */

package Chapter4;

import java.util.Arrays;
import java.util.List;

public class C4Demo2 {

    public static void main(String[] args) {

        List<Animal> animals = Arrays.asList(new Animal(75,"goat","Billy"),
                                             new Animal(90,"deer","Bambi"),
                                             new Animal(20,"turkey","Tom"),
                                             new Animal(400,"bear","Bob"),
                                             new Animal(300,"tiger","Tony"),
                                             new Animal(800,"cattle","Ferdinand"));


        //Basic stream to filter out a list of animals and only print those whose name starts with "B"
        //Much more compact that doing multiple iterations of a list
        //forEach is the terminal operation and accepts a Consumer.
        animals.stream()
                .filter(p -> p.getName().startsWith("B"))
                .forEach(p -> System.out.println(p.getName()));

        long count = animals.stream()
                .filter(p ->p.getWeight()>100)
                .count();

        System.out.println(count);


        //Does the same thing functionally but parallel streams allows the stream to be split into multiple threads
        long count1 = animals.parallelStream()
                .filter(p ->p.getWeight()>100)
                .count();

        System.out.println(count1);


        //Demonstrates the peek method which is an intermediate operation that takes a consumer and can
        //thus perform an action on the object.
        animals.stream()
                .peek(p -> p.setWeight(p.getWeight()*2))
                .peek(p-> p.getName())
                .forEach(p -> {} );

        System.out.println("*******************************");

        //Map converts the stream from an Animal Stream to an Integer stream in this case.
        //Map is an intermediate operation
        animals.stream().map( a-> a.getWeight()*2).forEach(System.out::println);


    }



}
