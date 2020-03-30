package com.unboxculture.desafio.arquitetura.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateTimeUtils {

    private DateTimeUtils() {
    }

    public static String formatDataBR(LocalDate date) {
        return Objects.nonNull(date) ? date.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) : null;
    }

    public static String formatDataHoraBR(LocalDateTime dateTime) {
        return Objects.nonNull(dateTime) ? dateTime.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")) : null;
    }

    public static String formatDataBR(LocalDateTime dateTime) {
        return Objects.nonNull(dateTime) ? dateTime.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) : null;
    }
}
