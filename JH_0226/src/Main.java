import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.WEDNESDAY;

public class Main {
    public static void main(String[] args) {
        scheduleList(2); //FEBRUARY
        System.out.println("-".repeat(135));
        System.out.println("Arriving Berlin time:" + calcArrivingTime(LocalDate.now()));
    }

    public static void scheduleList(int month) {
//    Описание занятия: 1) Составить список времен начала всех занятий по Java на февраль,
//    если предположить, что они проходят каждый понедельник/среду c 9:30 CET.
        LocalDate dateStart = LocalDate.of(2023, month,1);
        LocalDate dateEnd = LocalDate.of(2023, month,dateStart.lengthOfMonth());
        Map<LocalDate, String> list = new LinkedHashMap<>();
        LocalDate date = dateStart;
        while (date.getDayOfMonth() < dateEnd.getDayOfMonth()) {
            if (date.getDayOfWeek() == WEDNESDAY ||  date.getDayOfWeek() == MONDAY) {
                list.put(date, " " + date.getDayOfWeek() +" 9-30");
            }
            date = date.plusDays(1);
        }
        System.out.println(list.toString());
    }

    public static ZonedDateTime calcArrivingTime(LocalDate localDate) {
//     2) Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м.
//     Во сколько он прилетит? Написать метод, который мог бы совершать подобные вычисления.
        ZonedDateTime dateDeparture =
            ZonedDateTime.of(localDate.getYear(),
                            localDate.getMonthValue(),
                            localDate.getDayOfMonth(),15,5,0,0, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime dateArrival = dateDeparture.plusHours(10).plusMinutes(5) ;
        return dateArrival.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
    }
}

//    ZoneId zoneDeparture = ZoneId.of("America/Los_Angeles");
//    ZonedDateTime dateDeparture = ZonedDateTime.of(2023, 2,26,15,5,0,0,zoneDeparture);
//        System.out.println("Departure time LA: "+dateDeparture);
//
//                ZonedDateTime losAngTime = ZonedDateTime.now(zoneDeparture);
//                System.out.println("Current LA time: "+losAngTime);
//
//                ZoneId zoneArrival= ZoneId.of("Europe/Berlin");
//                ZonedDateTime berlinTime = ZonedDateTime.now(zoneArrival);
//                System.out.println("Current Berlin  time: " + berlinTime);
//
//                ZonedDateTime dateArrival;
//
//                dateArrival = dateDeparture.plusHours(10).plusMinutes(5) ;
//                System.out.println("Arriving LA time:" + dateArrival);
//                System.out.println("Arriving Berlin time:" +dateArrival.withZoneSameInstant(ZoneId.from(berlinTime)));

