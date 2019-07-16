/**
 * This file illustrates the following concepts from Chapter 2 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Factory pattern
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */



package Chapter2;

public abstract class Food {

    // == Instance Variables

    private int quantity;

    // == Constructors

    public Food(int quantity){
        this.quantity = quantity;
    }

    // == Methods

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();

}//close class


class Hay extends Food{

    public Hay(int quantity){
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Hay eaten: " +getQuantity());
    }
}//close class

class Pellets extends Food{

    public Pellets(int quantity){
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Pellets eaten: " +getQuantity());
    }
} //close class


/**
 * Factory Method to create food objects user tells us what type of animal they want to feed and we
 * return the right type of food. This class uses one static method so no object needs to be instantiated to use it
 * */

class FoodFactory{

    public static Food getFood(String animalName){
        switch(animalName){
            case "zebra":
                return new Hay(100);
            case "rabbit":
                return new Pellets(5);
             default:
                 throw new UnsupportedOperationException("Unsupported Animal: " +animalName);
        } //close case

    } //close method

} //close class

