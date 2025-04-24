
package org.uninpahu.Services;

import java.sql.Time;
import java.time.Duration;


public class DurationToTime {
    
    public static Time convertirDuration(Duration duration) {
        long hours = duration.toHours(); // Obtén horas
        long minutes = duration.toMinutes() % 60; // Obtén minutos
        long seconds = duration.getSeconds() % 60; // Obtén segundos restantes
        
        // Formato HH:MM:SS para Time
        return Time.valueOf(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

}
