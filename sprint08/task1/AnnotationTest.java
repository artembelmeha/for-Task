import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//Create marker-annotation CamelCase which will check whether method named according
// to code conventions. Create class CheckCamelCase for checking if all the annotated methods
// of some class satisfy naming pattern. This class contains constant 'CAMELCASE_PATTERN' that introduces
// regex for checking method name. Also this class contains method checkAndPrint(Class clazz) which returns
// true if all annotated methods of class satisfy 'CAMELCASE_PATTERN' and prints to standard output
// information about all incorrect method names by template: method <className>.<methodName> doesn't
// satisfy camelCase naming convention. For example
//
//}
//    call CheckCamelCase.checkAndPrint(Class1.class)
//        prints to console
//        method Class1.InCorrect doesn't satisfy camelCase naming convention
import static java.lang.annotation.RetentionPolicy.CLASS;


// INSERT CODE HERE
@Retention(RUNTIME)
@Target({ElementType.METHOD})
@interface CamelCase {

}

class CheckCamelCase {


    public static final String CAMELCASE_PATTERN = "([a-z][a-zA-Z0-9]+)+";


    public static boolean checkAndPrint(Class clazz) {
        if(clazz == null) throw new NullPointerException("classType must not be null");
        List<String>list  = Arrays.stream(clazz.getMethods())
                .filter(s->s.isAnnotationPresent(CamelCase.class))
                .filter(s->!s.getName().matches(CAMELCASE_PATTERN))
                .map(s->"method "+clazz.getName()+"."+s.getName()+" doesn't satisfy camelCase naming convention")
                .collect(Collectors.toList());
        if (list.size() == 0) {
            return true;
        } else {
            for (String s: list) {
                System.out.println(s);
            }
            return false;
        }
    }
}


class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {

    }
}
public class AnnotationTest{
    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(CheckCamelCase.checkAndPrint(Class2.class));

    }
}


