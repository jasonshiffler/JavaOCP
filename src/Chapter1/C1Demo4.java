/**
 * This file illustrates the following concepts from Chapter 1 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * Nested Classes (use sparingly, part of the benefit of classes is code reuse)
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */

package Chapter1;


public class C1Demo4 {

    //A static nested class is a static class defined at a member level.
    //it can be instantiated without an object at the member level so it
    //can't access instance variables without an explict object of the enclosing class
    static class StaticClass{

    }


    //This is a member inner class since it's defined at the same level as methods, instance vars, and constructors.
    public class MemberInnerClass1{

        private String test = "MemberInnerClass1";

        MemberInnerClass1(){
            System.out.println(test); //can access members of the outer class including private members.
        }
    }

    //can be private, default, protected, public, final
    final private class MemberInnerClass2{

    }

    //and abstract
    abstract class MemberInnerClass3{

    }

    //It is possible to have private interfaces that can only be referred to in the outer class
    //Methods must still be public
    private interface Secret{
        public void shh();
        //protected void nope(); //methods in an interface must be public
    }



    class DontTell implements Secret{
        @Override
        public void shh() {

        }
    }


    //Even this is private its accessible to a member inner class
    private String test = "Test";

    public static void main(String[] args) {

        C1Demo4 demo = new C1Demo4();

        MemberInnerClass1 member1 = demo.new MemberInnerClass1();
        //MemberInnerClass1 member2 = new MemberInnerClass1(); //Can't create an inner class from a static context

        StaticClass staticClass = new StaticClass(); //can be instantiated without an instance of the enclosing class.
    }


    void go(){

        int x = 0;
        final int y = 44;

        /*a class can be defined from within a method
        This is called a local inner class
         */
        class thing{

            thing(){
                System.out.println(test); //has access to outer class member variables
                //System.out.println(x); //Local vars can't be referred to unless they are effectively final
                System.out.println(y); //y is final so this is ok

            } // close constructor
        }//close class

         x=2; //This makes x effectively not final


        /*
        This is an anonymous inner class. it allows us to extend an abstract class on the fly
         */
        MemberInnerClass3 anon = new MemberInnerClass3() {
            int dollars  = 4;  };                             //note the required ;

    } //close method




}
