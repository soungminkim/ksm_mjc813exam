package com.mjc813.studyjava;

public class Machine {
    protected String model;
    public Machine(String m) {
        this.model = m;
    }
    public void printModel() {
        System.out.println(this.model);
    }
}
