package com.udemy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Autowired
    private FortuneService fortuneService;

//    @Autowired
//    public void setFortuneServiceMethodRandomName(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
