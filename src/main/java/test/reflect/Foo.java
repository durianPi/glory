package test.reflect;

/**
 * @author: DreamLee
 * @date: Created on 9:28 2018/11/3
 * @description:
 * @modified:
 */
public class Foo {

    private String a = "a";

    public Integer i = 1;

    public Foo() {
        System.out.println("Foo");
    }

    public void methodFoo() {
        System.out.println("methodFoo");
    }

    private void privateMethodFoo() {
        System.out.println("privateMethodFoo");
    }
}
