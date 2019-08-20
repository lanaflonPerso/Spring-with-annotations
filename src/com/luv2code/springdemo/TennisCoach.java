package com.luv2code.springdemo;

import com.luv2code.springdemo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    //can put @autowired here so you don't need constructor or setter injection (field injection). The technique is ca lled reflection
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("inside default construction");
    }

/*
    //define a constructor for the injection using the autowired annotation
    //Autowired will scan for beans that implement the FS interface (in this case HappyFortuneService)
    @Autowired
    public TennisCoach (FortuneService theFortuneService) { //this makes a basketball coach object with a specified (by argument) f.s.
        fortuneService = theFortuneService;
    }+*/

//settermethod (can use any method)
    @Autowired
    @Qualifier("randomFortuneService") //in case there ismore than one implementation of the interface. Lower case because we're referencing the defautlt-generated bean id
    public void anyMethodNameToSetService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("inside setter for Tennis coach");
    }

    @Override
    public String getDailyWorkout() {
        return "play with your balls";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}

