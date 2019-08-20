package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
private String[] fortuneArray = {
        "today is your lucky day",
        "Use the force",
        "No pain no gain"
};

    @Override
    public String getFortune() {

        System.out.println("inside random FS");

        Random myRandom = new Random();
        int index = myRandom.nextInt(fortuneArray.length);
        return fortuneArray[index];
    }
}
