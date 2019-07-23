/**
 * This file illustrates the following concepts from Chapter 5 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * Creating custom exceptions
 *
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 *
 */


package Chapter6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class C6Demo1 {

    public static void main(String[] args) throws CannotSwimException{

        //Try uncommenting these to see the different output

       // throw new CannotSwimException();

       // throw new CannotSwimException(new RuntimeException());

       // throw new CannotSwimException("Broken fin");


        try{
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);

        }
        //catch(FileNotFoundException | IOException e){ //Since FileNotFoundException is a subclass of IO Exception
                                                        //This doesn't work. Multi-catch intended for unrelated Except.

        catch(DateTimeParseException | IOException e){  //Multi-catch allows us to handle multiple exception types
            e.printStackTrace();                          //in one catch block so we don't have to duplicate code to
            throw new RuntimeException();                 //handle
            //e = new RuntimeException();              //e is effectively final, cant assign to something esle
        }


    } //close main


}


class CannotSwimException extends Exception { //checked exception since it extends from Exception

    public CannotSwimException(){
        super();
    }

    public CannotSwimException(Exception e){ //shows how to wrap another exception inside yours
        super(e);
    }

    public CannotSwimException(String message){ //How to pass a custom error message
        super(message);
    }


}

class DangerInTheWater extends RuntimeException{} //unchecked exception since it extends Runtime Exception

class SharkInTheWaterException extends DangerInTheWater{}