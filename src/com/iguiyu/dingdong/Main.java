package com.iguiyu.dingdong;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Main {
    public Main() {
    }

    @PostConstruct
    public void demo() {
        ArrayList listA = new ArrayList();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.setName("name1");
        p1.setOrder(Integer.valueOf(1));
        p2.setName("name2");
        p2.setOrder(Integer.valueOf(2));
        p3.setName("name3");
        p3.setOrder(Integer.valueOf(3));
        listA.add(p2);
        listA.add(p1);
        listA.add(p3);
        Collections.sort(listA);
        Iterator i$ = listA.iterator();

        while(i$.hasNext()) {
            Person p = (Person)i$.next();
            System.out.println(">>>>>>>>>>>>>>>>>>>>" + p.getName());
        }

    }
}
