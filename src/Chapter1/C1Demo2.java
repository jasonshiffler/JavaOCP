/**
 * This file illustrates the following concepts from Chapter 1 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -virtual methods
 * -@Override
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */
package Chapter1;

public class C1Demo2 {


    public static void main(String[] args) {
        C1Demo2 demo = new C1Demo2();
        demo.go();
    }

    void go(){

        Animal cub = new Bear();
        cub.play();                   //cub will use subclass method since its a bear object
        System.out.println(cub.name); //but use the class variable since its a Animal type
                                      //uses virtual methods, not virtual variables!

        Animal cub2 = new Bear();
        System.out.println(cub2.equals(cub)); //Are these two object equivalent
    }
}

abstract class Animal {

    String name = "not so sure";

    public void play() {
        System.out.println("Pet the animal");
    }
}

class Bear extends Animal {
    String name = "I'm a Bear";
    public int weight = 50;

                //Override let's the compiler know you intend to Override a method
    @Override  //This allows the compiler to tell you if something wasn't overriden as intended
    public void play() {
        System.out.println("Feed me!");
    }

    @Override
    public String toString(){
        return(name);
    }

    //The top level equals method takes an object as a parameter
    @Override
    public boolean equals(Object b){

        if((b == null) || ((b instanceof Bear) == false)) //Use of short circuit operator to stop further checking
            return false;                                 //If it's null
        else if(((Bear)b).weight != this.weight)
            return false;
        else
            return true;
    }

    /*
    @Override     //There isn't a superclass method with the same signature to Override!
    public void play(int num) {
        System.out.println("Feed me!");
    }
    */
}