package com.iguiyu.dingdong;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Person implements Comparable<Person> {
    private String name;
    private Integer order;

    public Person() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public int compareTo(Person arg0) {
        return this.getOrder().compareTo(arg0.getOrder());
    }
}
