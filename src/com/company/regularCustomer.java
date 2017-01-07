package com.company;

class regularCustomer extends Customer {
    regularCustomer(String f, String l) {
        super(f, l);
        membership = 65;
        classes = 10;
        retail = 0;
        aquatics = 0;
        trainer = 25;
    }
}
