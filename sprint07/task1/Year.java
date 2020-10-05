import java.time.LocalDate;

public class Year {
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year,1,1).isLeapYear();
    }
}

