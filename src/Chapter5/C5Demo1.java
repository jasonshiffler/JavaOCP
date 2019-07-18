/**
 * This file illustrates the following concepts from Chapter 5 of the OCP Java SE 8 Study Guide.
 * Think like the compiler!
 *
 * -ZonedDateTime
 * -Periods
 *
 * Uncomment purposefully inserted mistakes to see the compiler errors
 */

package Chapter5;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class C5Demo1 {

    public static void main(String[] args) {

        ZoneId zone = ZoneId.of("US/Eastern");

        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        LocalDateTime dateTime1 = LocalDateTime.now();

        //Different ways to create a Zoned Date/Time
        ZonedDateTime zoned1 = ZonedDateTime.of(2019, 7,17, 21,24,0,200,zone);
        System.out.println(zoned1);

        ZonedDateTime zoned2 = ZonedDateTime.of(date1,time1,zone);
        System.out.println(zoned2);

        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1,zone);
        System.out.println(zoned3);


        //convert the date/time to seconds since Epoch. January 1, 1970
        long seconds = zoned3.toEpochSecond();


        /**
         * Periods can be created in multiple different ways. The output is
         * P1Y2M3D
         *
         * You can specify Years, Months, and Days
         *
         * Smallest unit of measure is a Day
         * */

        Period p1 = Period.of(1,2,3);
        System.out.println(p1);

        Period p2 = Period.ofDays(2);
        System.out.println(p2);

        Period p3 = Period.ofWeeks(3);
        System.out.println(p3);

        /**
         * Durations are for smaller units of time
         * Days, hours, minutes, seconds, and nanoseconds
         *
         * */

        Duration hourly = Duration.ofHours(4);
        System.out.println(hourly);

        Duration milli = Duration.ofMillis(34);
        System.out.println(milli);

        /**
         * Can also use ChronoUnits to build Durations
         */
        Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
        System.out.println(everyTenSeconds);


        Duration hour = Duration.ofSeconds(3600);
        System.out.println(hour);                //The output will be PT1H


        /**
         * ChronUnits can help determine time differences
         */
        LocalTime time4 = LocalTime.now();
        LocalTime time5 = LocalTime.of(6,15);
        System.out.println(ChronoUnit.SECONDS.between(time5,time4));


        LocalDate date3 =  LocalDate.now();
        Duration sixHours = Duration.ofHours(6);
        //System.out.println(date3.plus(sixHours)); //Fails because we can't add time to a date object


        /**
         * Durations are fundamentally units of time/seconds and can't be added to date only objects
         */

        LocalDate date4 =  LocalDate.now();
        Duration sixDays = Duration.ofDays(6);
        //System.out.println(date3.plus(sixDays)); //Fails because we can't add time to a date object


    }

}
