package org.uninpahu.Services;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

public class TimeToDuration {
    
    // Método para convertir java.sql.Time a Duration
    public static Duration convertSqlTimeToDuration(Time time) {
        if (time == null) {
            return Duration.ZERO;
        }

        // Convertir el Time a LocalTime
        LocalTime localTime = time.toLocalTime();

        // Crear Duration a partir de las horas, minutos y segundos
        return Duration.ofHours(localTime.getHour())
                .plusMinutes(localTime.getMinute())
                .plusSeconds(localTime.getSecond());
    }
}
