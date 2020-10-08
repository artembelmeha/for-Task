import java.lang.annotation.*;
import java.lang.reflect.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


public class TestSuitHandler {
    static void run(Class<?> clazz){
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            String[] methods = clazz.getAnnotation(TestSuite.class).value();
            for (String stringMethod : methods) {
                try {
                    Method m = clazz.getMethod(stringMethod);
                    if (m.getModifiers() == 1 && m.getParameterCount() == 0) {
                        try {
                            System.out.println("\t -- Method " + clazz.getName()+"."+m.getName() + " started --");
                            m.invoke(clazz.getDeclaredConstructor().newInstance());
                            System.out.println("\t -- Method " +  clazz.getName()+"."+ m.getName() + " finished --");
                        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("Method with name " + stringMethod + " doesn't exists or not public in class " + clazz.getName());
                }
            }
        } else {
            System.out.println("Class "+clazz.getName()+" isn't annotated");
        }

    }

    public static void main(String[] args) {
        TestSuitHandler.run(Class11.class);
    }
}
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite{
    String [] value();
}
