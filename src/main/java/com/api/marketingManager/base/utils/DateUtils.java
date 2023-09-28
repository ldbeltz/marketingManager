package com.api.marketingManager.base.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
        throw new IllegalArgumentException("Classe utilitária");
    }

    public static String formatData(LocalDate date){
        return (date != null) ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public static LocalDate formatData(String date){
        return (date != null) ? LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    public static LocalDate dateSqlToLocalDate(Date date) {
        return (date != null) ? date.toLocalDate() : null;
    }
}
