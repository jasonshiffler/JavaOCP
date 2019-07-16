/**
 * This file illustrates the following concepts from Chapter 2 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Singleton Pattern
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */

package Chapter2;

public class HayStorage {


    // == Instance Variables

    private int quantity = 0;
    private static final HayStorage instance = new HayStorage(); //Creates a single instance of the object
                                                                 //when the class is loaded
                                                                 //final assures that only one object is created

    //The Singleton could have been created with a static initialization block as well

    /*
    private static final HayStorage instance;
    static {
        instance = new HayStorage();
    }

    */


    // == Constructors

    /**
     * The constructor is private so the object can't be created from the outside
     */

    private HayStorage(){}

    // == Methods

    /**
     * This method allows to retrieve the object that was created when the class was loaded
     **/
    public static HayStorage getInstance(){
        return instance;
    }

    /**
     * This is lazy instantiation where the the instance is created on demand. This saves memory but is a little
     * slower when first called
     **/
    public static HayStorage getLazyInstance(){
        if (instance == null){
           // instance = new HayStorage(); //Had to comment out since instance is final in another example in the class
        }
        return instance;
    }




    public void addHay(int amount){
        quantity += amount;
    }

    public boolean removeHay(int amount){
        if(quantity < amount)
            return false;
        quantity -= amount;
        return true;
    }



}
