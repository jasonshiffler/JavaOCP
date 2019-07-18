/**
 * This file illustrates the following concepts from Chapter 3 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Generics
 * -Bounds
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */


package Chapter3;

import java.util.ArrayList;
import java.util.List;

public class C3Demo1 {


    public static void main(String[] args) {
        Crate <String> crate = new Crate<>();
        crate.packCrate("String");
        //crate.packCrate(new Integer(3)); //We've already determined that we can put Strings into the Crate

        //If we need to support another type we can create a new Crate to accommodate
        Crate <Integer> intCrate = new Crate<>();
        intCrate.packCrate(new Integer(3));

        /* This isn't allowed since Crate<String> becomes Crate<Object> at compile time
        if (crate instanceof Crate<String>){
            System.out.println("Nope");
        }*/

        List<String> stringList = new ArrayList<>();

        stringList.add("First");
        stringList.add("Second");
        stringList.add("Third");

        //List<Object> list = stringList; //Even though String is a subtype of object the compiler doesn't accept this

        List<?> list = stringList; // ? is an unbounded wildcard that states that any type is ok

        //List<Number> nlist = new ArrayList<Integer>(); //Again Generic types only work for the specific type that
                                                         //is specified

        List<? extends Number> nlist1 = new ArrayList<Integer>(); // ? extends states that any subclass type is ok.
        List<? extends Number> nlist2 = new ArrayList<Number>();  // ? extends states that any subclass  or the same
                                                                  // class type is ok.
        List<? super Integer> ilist1 = new ArrayList<Number>();    // ? super works in the opposite direction, any super
        List<? super Integer> ilist2 = new ArrayList<Integer>();   //type or the same type is permitted

    }
}

/**
 *Allows us to put any object type (<T>) we want into the Crate. With this approach the caller doesn't have to worry
 * about casting the object from an Object type. The type checking however is only performed at compile time. Behind
 * the scenes all references to T are replaced with Object types. This is called type erasure. Will most often be used
 * when writing code that others will use.
 *
 */
class Crate<T>{

    private T contents;

    public T emptyCrate(){
        return contents;
    }

    public void packCrate(T contents){
        this.contents = contents;
    }

    //Generics can be declared in methods as well
    public static <T> Crate<T> ship(T t){
        System.out.println("Preparing " + t);

        return new Crate<T>();
    }

} //close class


/**
 * We can have generics in interfaces as well
 */
interface Container<T>{
    void ship (T t);
}

/**
 * The concrete class can define the object type it will accept
 */
class Box implements Container<String>{

  public void ship (String s){   //must be defined as public since the interface method is public

    }
}


/**
 * The concrete class can define the object type it will accept, but it doesn't have to
 */
class Cylinder<T> implements Container<T>{

   public void ship (T t){         //must be defined as public since the interface method is public

    }

}




