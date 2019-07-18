/**
 * This file illustrates the following concepts from Chapter 3 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Comparable
 * -Comparator
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */


package Chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class implements the Comparable Interface so we can compare Lions
 */
class Lion implements Comparable<Lion>{

    // == Parameters

    private int weight;
    private int speed;

    // == Constructors

    public Lion(int weight, int speed){
        this.weight = weight;
        this.speed = speed;
    }

    // == Methods

    public int getSpeed(){
        return this.speed;
    }


    /**
     * The compareTo method is required to implement the Comparable interface     *
     */

    @Override
    public int compareTo(Lion l) {
         return this.weight - l.weight;
            }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lion))
                return false;

        return (this.compareTo((Lion) obj) == 0);
    }

    @Override
    public String toString(){
        return "This Lion weighs " + weight + " pounds" + " and runs " + getSpeed() + " mph";
    }

}//close class


public class C3Demo3 {

    public static void main(String[] args) {
        Lion L1 = new Lion(50,25);
        Lion L2 = new Lion(100, 21);
        Lion L3 = new Lion(100,20);

        System.out.println("If > 1, lion 2 is bigger than lion 1 " +  L2.compareTo(L1));
        System.out.println("Is L2 the same as L3? " + L2.equals(L3));


        //The Comparator allows us to sort using other metrics besides what gets used for compareTo

        Comparator<Lion> bySpeed = (l1,l2) -> (l1.getSpeed() - l2.getSpeed());

        List<Lion> Lions = new ArrayList<>();

        Lions.add(L1);
        Lions.add(L2);
        Lions.add(L3);

        Collections.sort(Lions,bySpeed);
        System.out.println(Lions);


    }


}
