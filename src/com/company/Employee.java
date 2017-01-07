package com.company;

class Employee extends Customer {
    Employee(String f, String l) {
        super(f, l);
        membership = 1;
        classes = 3;
        retail = 10;
        aquatics = 7;
        trainer = 15;
    }
}
