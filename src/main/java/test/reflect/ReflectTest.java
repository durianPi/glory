package test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: DreamLee
 * @date: Created on 10:05 2018/1/22
 * @description:
 * @modified:
 */
public class ReflectTest {

    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }

        try {
            Class clazz = Class.forName("java.lang.String");
            Method method = clazz.getMethod("toLowerCase", null);
            Object obj = method.invoke("ABC");
            System.out.print(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (String s : args) {
            System.out.println(s);
        }
    }
}
