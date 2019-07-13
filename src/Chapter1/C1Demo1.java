/**
 * This file illustrates the following concepts from Chapter 1 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -instanceof operator
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */

package Chapter1;


public class C1Demo1 {


    interface Swims{}
    class Swimmer{}

    class Fish extends Swimmer {
        void makeBubbles(){
            System.out.println("Bubble, Bubble");
        }
    }

    class Duck extends Swimmer {
        void fly(){
            System.out.println("I'm flying");
        }
    }

    class Whale implements Swims{}


    public static void main(String[] args) {

        C1Demo1 demo = new C1Demo1();
        demo.go();
    }

    void go() {
        instanceOfDemo();
    }

/**
 * Shows how the intanceof demo works with classes, subclasses, and interfaces
 *
 * */

    void instanceOfDemo(){

        //We'd expect a Fish object to be an instance of a Fish class
        Swimmer boy = new Swimmer();
        System.out.println("Is a boy an instanceof Swimmer class? " + (boy instanceof Swimmer));

        //Does instanceof return true for a subclass?
        Fish fish = new Fish();
        System.out.println("Is a fish an instanceof Swimmer class? " + (fish instanceof Swimmer));

        //Does it work for sibling classes? -> Does't even compile
        //System.out.println("Is a fish an instanceof Duck class? " + (fish instanceof Duck));

        //Does instanceof work for interfaces?
        Whale whale = new Whale();
        System.out.println("Is a whale an instanceof Swims? " + (whale instanceof Swims));

        //instanceof compiles for interfaces even if they don't match
        System.out.println("Is a boy an instanceof Swims? " + (boy instanceof Swims));


       //instanceof can be used to to determine if an instance is a subclass of particular object before
        //applying an explicit cast. Not a great strategy

        Swimmer s = new Fish();
        if (s instanceof Fish){
            ((Fish)s).makeBubbles();
        }else if(s instanceof Duck){
            ((Duck)s).fly();
        }

    }//close method



} //close class
