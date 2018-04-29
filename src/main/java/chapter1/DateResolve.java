package chapter1;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateResolve {

    /**
     * LocalDateTime 代替 Calendar
     * Instant 代替 Date
     * DateTimeFormatter 代替 SimpleDateFormat
     */

    @Test
    public void testLocalDateTime() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }

    @Test
    public void testInstant(){
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant now     = Clock.systemDefaultZone().instant();
        Instant later   = now.plusSeconds(3);
        Instant earlier = now.minusSeconds(3);
        System.out.println(now);
        System.out.println(later);
        System.out.println(earlier);
    }

    @Test
    public void testDateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.format(formatter));
    }
}