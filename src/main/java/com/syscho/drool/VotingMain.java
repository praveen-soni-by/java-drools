package com.syscho.drool;

import com.syscho.drool.helper.DroolHelper;
import com.syscho.drool.vo.Person;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class VotingMain {

    public static void main(String[] args) {

        KieContainer kieContainer = DroolHelper.kieContainer();
        KieSession kieSession = kieContainer.newKieSession();

        Person person1 = buildPerson("Tony stack", 12);
        kieSession.insert(person1);

        Person person2 = buildPerson("Buggy", 22);
        kieSession.insert(person2);

        Person person3 = buildPerson("Ms Marvel", 27);
        kieSession.insert(person3);

        Person person4 = buildPerson("Bruce Wayne", 7);
        kieSession.insert(person4);

        Person person5 = buildPerson("Groot", 2);
        kieSession.insert(person5);

        kieSession.fireAllRules();

        kieSession.dispose();


        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);

    }

    private static Person buildPerson(String name, int age) {
        return Person.builder().name(name).age(age).build();
    }
}
