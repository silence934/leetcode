package xyz.nyist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.nyist.entity.Student;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/16 20:35
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ctx.getBean("helloWord", Student.class);
        System.out.println(student);
    }
}
