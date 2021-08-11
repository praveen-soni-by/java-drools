package com.syscho.drool.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {
    private String name;
    private int age;
    private boolean isEligForVote;
    private boolean isEligForAadharCard;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "| age=" + age +
                "| isEligForVote=" + isEligForVote +
                "| isEligForAadharCard=" + isEligForAadharCard;

    }
}


