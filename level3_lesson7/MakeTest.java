package level3_lesson7;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class MakeTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        start(Drive.class);
    }

    static Drive Testing = new Drive();

    public static void start(Class Tests) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        int isBefore = 0;
        int isAfter = 0;

        Method[] methods = Tests.getDeclaredMethods();
        LinkedList<Method> list = new LinkedList<>();

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Anno.class))
                list.add(methods[i]);
        }

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Anno.class))
                list.set(methods[i].getAnnotation(Anno.class).id() - 1, methods[i]);
        }

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                list.push(methods[i]);
                isBefore++;
            }
            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                list.add(methods[i]);
                isAfter++;
            }
        }
        if (isBefore > 1 || isAfter > 1)
            throw new RuntimeException("2 times AfterSuite or BeforeSuite");

        for (Method method : list) {
            method.invoke(Testing);
        }
    }
}

