/**
 * This file illustrates the following concepts from Chapter 5 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * Locale
 * Internationalization
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 *
*/

package Chapter5;


import java.util.Locale;

public class C5Demo2 {

    public static void main(String[] args) {

        Locale locale1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        System.out.println(locale1);

        //Ok but bad form, language should be lower case, Country should be uppercase
        Locale locale2 = new Locale.Builder().setLanguage("EN").setRegion("us").build();
        System.out.println(locale2);



    }



}
