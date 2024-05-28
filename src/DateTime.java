import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTime {
    String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    String getTIme() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
