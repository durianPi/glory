package com.gupao.pattern.factory.simplefactory;

/**
 * @author: dreamlee
 * @create: on 10:07 PM 3/6/19
 * @modify:
 * @desciption:
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create("java");
        course.record();
    }
}
