import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


//        Create annotation Review with two string elements: reviewer and date.
//        Element date has default string value today.
//        This annotation can be applied to class when we execute static method review(String className) of class Util
//        and the result of this method will be printed Class <ClassName> was reviewed <date in format yyyy-mm-dd>
//        by <reviewer> to standard output (console).
//        If the class <className> isn’t annotated we show message: Class <ClassName> isn't marked as Reviewed.
//        If the class was not found we show message: Class <ClassName> was not found.

@Review(reviewer = "111", date = "222")
public class Util {

    public static void main(String[] args) {

    }
    static void review(String className) {
        Class <?> clazz;
        try {
            clazz =Class.forName(className);
            Review review = clazz.getAnnotation(Review.class);
            if (clazz.isAnnotationPresent(Review.class)) {
                String date="";
                if (review.date().equals("today")) {
                    date=  LocalDate.now().toString();
                } else { date = review.date(); }
                System.out.println("Class "+className+" was reviewed "+date+" by "+review.reviewer()+".");
            } else {
                System.out.println("Class "+className+" isn't marked as Reviewed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class "+ className +" was not found");
        }
    }
}
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();
    String date ()  default "today";

}
