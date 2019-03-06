package com.gupao.pattern.factory.simplefactory;

/**
 * @author: dreamlee
 * @create: on 10:09 PM 3/6/19
 * @modify:
 * @desciption:
 */
public class CourseFactory {

    public ICourse create(Class clazz) {
        try {
            if (null != clazz) {
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
