package com.hades.java.example.annotation;

import com.hades.java.example.annotation.test_Inherited.*;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {

    @Test
    public void test_annotation_of_interface() {
        Annotation[] list = IStu.class.getAnnotations();
        /**
         * @java.lang.annotation.Retention(value=RUNTIME)
         * @java.lang.annotation.Target(value={TYPE})
         * @java.lang.annotation.Inherited()
         */
        print(list);
    }

    // @Inherited,START

    /**
     * 结论：类实现 - 实现类中包括被@Inherited修饰的注解
     */
    @Test
    public void test_annotation_of_parentClass() {
        {
            Annotation[] list = Stu.class.getAnnotations();
            /**
             * @com.hades.java.example.annotation.IStu()
             */
            print(list);

//        IStu stu = new Stu();  // Error: compile error. because Stu is not a IStu
            Stu stu = new Stu();
            System.out.println(stu);
        }
        System.out.println("--------");
        {
            Annotation[] list = Stu2.class.getAnnotations();
            /**
             * @com.hades.java.example.annotation.test_Inherited.IStu2()
             */
            print(list);
        }
    }

    /***
     * 结论：类继承 - 子类会继承父类的被@Inherited修饰的注解。
     */
    @Test
    public void test_annotation_of_childClass() {
        {
            Annotation[] list = UniversityStu.class.getAnnotations();
            /**
             * @com.hades.java.example.annotation.IStu()
             */
            print(list);
        }

        System.out.println("---");
        {
            Annotation[] list = UniversityStu2.class.getAnnotations();
            /**
             * nothing
             */
            print(list);
        }
    }


    /***
     * 结论：接口继承 - 子接口不继承父接口的任何注解。
     */
    @Test
    public void test_annotation_of_extends() {
        Annotation[] list = PureStu.class.getAnnotations();
        // nothing
        print(list);
    }
    // @Inherited,END


    private void print(Annotation[] list) {
        for (Annotation item : list) {
            System.out.println(item.toString());
        }
    }
}