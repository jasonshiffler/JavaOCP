/**
 * This file illustrates the following concepts from Chapter 1 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -Enums
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */

package Chapter1;


//Enums are like a set of constants, doesn't have to be uppercase but that is the convention

enum Days{ SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

//enum Weekend extends Days { SUNDAY, SATURDAY} //enums can't be extended


//enums can also contain state
enum Season {

    //note that the ; is needed in an enum if there is anything in the enum besides the value
    SPRING("Mild"), SUMMER("Hot"), FALL("Mild"), WINTER("Cold");

  private String temp;

  private Season(String temperature){
      this.temp = temperature;
  }

    public void printTemp() {
        System.out.println(temp);
    }
} //close enum

public class C1Demo3 {


    public static void main(String[] args) {

        Days d = Days.MONDAY;
        System.out.println(d);
        System.out.println(Days.MONDAY);
        System.out.println(d == Days.MONDAY);

        for (Days day : Days.values())  //How to iterate through an enum
            System.out.println(day + " " + day.ordinal()); //ordinal is the sequence in which the value appears

        //if (Days.SUNDAY == 0){} //It's an enum not a primitive so this doesn't work

        Days d1 = Days.MONDAY.valueOf("MONDAY"); //An enum can be created from a String using .valueOf()
        //Days d2 = Days.MONDAY.valueOf("Monday"); //it must match

        Days friday = Days.FRIDAY; //enums can be used in switch statements

        switch (friday){
            case FRIDAY:
                System.out.println("its the weekend!");
                break;
            case MONDAY:
                System.out.println("boo!");
                break;

        } //close switch

        Season s = Season.FALL;
        s.printTemp();   //print out the value stored with the enum


    }// close method




} //close class
