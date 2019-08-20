package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read the Spring Config file (set the package for the Spring component scan)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve the bean from the container
        Coach theCoach = context.getBean("tennisCoach", Coach.class); //whacky syntax to say: instantiate an object of the interface class, whose particular instatiation is defined as mycoach in the application context

        //apply the method (no change here)
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        context.close();
    }
}
