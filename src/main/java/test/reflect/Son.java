package test.reflect;

/**
 * @author: DreamLee
 * @date: Created on 9:28 2018/11/3
 * @description:
 * @modified:
 */
public class Son extends Foo {

    private String b = "b";

    public Son() {
        System.out.println("Son");
    }

    private Son(String b) {
        this.b = b;
    }

    public void methodSon() {
        System.out.println("methodSon");
    }

    public void privateMethodSon() {
        System.out.println("privateMethodSon");
    }
}
