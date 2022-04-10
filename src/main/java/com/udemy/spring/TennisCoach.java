package com.udemy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
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

    @PostConstruct
    private void startUp(){
        System.out.println("Some PostConstruct method");
    }

    @PreDestroy
    private void tearDown(){
        System.out.println("Some PreDestroy method");
    }
}
