package br.com.homework.applicant.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate dateTransformer(String pattern, String dateWritten){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String date =dateWritten;

        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
