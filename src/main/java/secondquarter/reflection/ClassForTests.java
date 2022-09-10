package secondquarter.reflection;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassForTests {

    static void doTests(Class<?> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance();

        Method[] methods = clazz.getMethods();
        Method firstMethod = null;
        Method lastMethod = null;
        List<Method> methodList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && method.isAnnotationPresent(MyAnnotation.class)){
                methodList.add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)){
                firstMethod = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)){
                lastMethod = method;
            }
        }

        methodList.sort(Comparator.comparingInt(m -> m.getAnnotation(MyAnnotation.class).value()));

        firstMethod.invoke(o);
        for (Method method : methodList) {
            method.invoke(o);
        }
        lastMethod.invoke(o);
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        doTests(Cat.class);
    }
}
