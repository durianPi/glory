package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author: DreamLee
 * @date: Created on 9:26 2018/11/3
 * @description:
 * @modified:
 */
public class ReflectTest2 {

    public static void main(String[] args) {
//      Son son = new Son();
//      printClassMessage(son);
        ArrayList<String> list = new ArrayList<>();
        Class<? extends ArrayList> listClass = list.getClass();
        try {
            Method add = listClass.getMethod("add", Object.class );
            add.invoke(list, 1);
            System.out.println(list);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void printClassMessage(Object obj){
        //要获取类的信息，首先要获取类的类类型
        Class c = obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("累的名称是："+c.getName());

        /*
         * Method类，方法的对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是多有该类自己声明的方法，不问访问权限
         */
        Method[] ms = c.getMethods();//c.getDeclaredMethods();
        for(int i =0; i < ms.length; i++){
            //得到方法的返回值类型的类类型
            Class retrunType = ms[i].getReturnType();
            System.out.print(retrunType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取的参数类型--->得到的是参数列表的类型的类类型
            Class[] paraTypes = ms[i].getParameterTypes();
            for(Class class1 : paraTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }

        /**
         * 成员变量也是对象，是java.lang.reflect.Field这个类的的对象
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有public的成员变量的信息
         * getDeclareFields()方法获取的是该类自己声明的成员变量的信息
         */
        Field[] fs = c.getFields();
        for(Field field : fs){
            //得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.print(typeName+" "+fieldName);
        }

        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructor()方法获取所有的public的构造函数
         * getDeclaredConstructors得到所有的构造函数
         */
//        Constructor[] cs = c.getConstructors();
//        for(Constructor constructor : cs){
//            System.out.print(constructor.getName()+"(");
//            //获取构造函数的参数列表---》得到的是参数雷彪的类类型
//            Class[] paramTypes = constructor.getParameterTypes();
//            for(Class class1 : paramTypes){
//                System.out.print(class1.getName()+",");
//            }
//            System.out.println(")");
//        }
    }
}
