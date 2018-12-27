package test;

import javax.xml.stream.XMLStreamException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DreamLee
 * @description:
 * @date: Created in 13:09 2018/1/19
 * @modified:
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(5 >> 2);
//        System.out.println(5/2);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        System.out.println(map.get("1"));
        char c = '0';
        System.out.println(((int) c));
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(1.0f==1);
        XMLStreamException xmlStreamException = new XMLStreamException();

        double a = 3;

        Integer i = 1;
        Long l = 1l;
        Double d = 1d;
        int i1 = 1;
        long l1 = 1l;
        double d1 = 1d;
        System.out.println(l1 == i1);
        System.out.println(d == c);
        System.out.println();
    }

    final void test() {

    }
}
