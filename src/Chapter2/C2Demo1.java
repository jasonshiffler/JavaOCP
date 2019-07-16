/**
 * This file illustrates the following concepts from Chapter 2 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Functional Interfaces
 * -Lambda Expressions
 * -Polymorphism
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */
package Chapter2;


import java.util.function.Predicate; //Allows use to use an existing functional interface
                                     //so we don't have to write our own


/**This annotation let's the compiler and other developers know this is
intended to be a functional interface and more abstract methods shouldn't be added
 */
@FunctionalInterface
interface Sprint{        //Sprint is a Functional interface because it has a single abstract method
    public void run();
}

/**
 * This is a valid functional interface since it has a total of one abstract method including its methods
 * and the methods inherited from Sprint
 */
@FunctionalInterface
interface Run extends Sprint{

}

/**
 * This is a valid functional interface since it has a total of one abstract method including its methods
 * and the methods inherited from Sprint. The default and static methods don't impact its functional interface
 * status
 */

@FunctionalInterface
interface Skip extends Sprint{

    public default int getHops(int rabbits){
        return 10;
    }
    public static void skip(int speed){

    }
}

/**
 * Doesn't contain an abstract method so it doesn't qualify as a functional interface
 */
/*
@FunctionalInterface
interface fly{}
*/

/**
 * Contains more than one abstract method so it doesn't qualify as a functional interface
 *
 */
/*
@FunctionalInterface
interface fly{
 public void flap();
 public void loop();
}
*/

class Animal{

    // == instance variables ==

    private String species;
    private boolean canHop;
    private boolean canSwim;


    // == constructors

    public Animal (String speciesName, boolean hopper, boolean swimmer){
        this.species = speciesName;
        this.canHop = hopper;
        this.canSwim = swimmer;
    }

    // == Methods

    public boolean canHop() {return canHop;}
    public boolean canSwim() {return canSwim;}
    public String toString() {return species;}

} // close class

class Lion extends Animal{

    Lion(){
        super("Lion",false,true);
    }

    public void roar() {
        System.out.println("RRROOOAAARRR!");
    }

}



/**
 * This will be the functional interface we use to check different traits
 * */
@FunctionalInterface
interface CheckTrait{
    public boolean test(Animal a);

}

public class C2Demo1 {

    /**
     * The method takes both the class to be a checked as well as the functional interface
     * */
    private static void print(Animal animal, CheckTrait trait){
        if(trait.test(animal))                                  //This is our single abstract method
            System.out.println(animal);
    }

    /**
     * The method does the same thing as print while using the Predicate interface
     * */
    private static void printPredicate(Animal animal, Predicate<Animal> trait){

        if(trait.test(animal));                   //The method is called test because that's how it's defined in the
            System.out.println(animal);           //interface
    }


    public static void main(String[] args) {

      Animal animal =new Animal("fish",false, true);
      print(animal , a->a.canHop());
      print(animal, (Animal b) -> b.canHop()); // () a required since we're specifying the type
      print(animal, (Animal c) -> {return c.canHop(); }  ); // {} are required if we add the return statement

      printPredicate(animal, d->d.canHop());

        /**
         * We've reached the section to demo polymorphism
         */

      //Lion lion = new Animal("Lion",false, true);   //A Lion can't reference an Animal
      Animal cat = new Lion();                        //An Animal can reference a Lion
     //cat.roar();                                    //It can't roar because the Animal reference can't access that
                                                      //method


        if((cat != null) && (cat instanceof Lion)) { //instanceof helps us avoid ClassCastExceptions
            Lion l;
            l = (Lion)cat;                //We can point an Lion ref to cat if we do a cast
            l.roar();
        }


    }


}
