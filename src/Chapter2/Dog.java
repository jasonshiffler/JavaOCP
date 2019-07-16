/**
 * This file illustrates the following concepts from Chapter 2 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Immutable Object pattern
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
*/

package Chapter2;

import java.util.ArrayList;
import java.util.List;

//Class is marked final so none of the methods can be overriden

public final class Dog {

    // == Instance Variables - All private for an immutable class

    private final List<String> favoriteFoods;
    private final String name;
    private final int age;

    // == Constructors

    public Dog(List<String> favoriteFoods, String name, int age){
        if (favoriteFoods == null){
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods); //Create a new ArrayList so no one has a reference
        this.name = name;                                          //to the list this object is using
        this.age = age;
    }

    // == methods - No setters for an immutable class, also none return a reference variable


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }

    public String getFavoriteFoods(int index){
        return favoriteFoods.get(index);
    }


} //close class
