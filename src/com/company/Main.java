package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean i[] = new boolean[4];
        System.out.println("Greetings! Please type in your first name.");
        Scanner input = new Scanner(System.in);
        while (true) { //first
            String firstName = input.nextLine();
            if (firstName.contains(" ")) {
                System.out.println("No spaces please.\nTry again.");
                continue;
            }
            else {
                System.out.println("Now type in your last name.");
                while (true) { //second
                    String lastName = input.nextLine();
                    if (lastName.contains(" ")) {
                        System.out.println("No spaces please.\nTry again.");
                        continue;
                    }
                    else {
                        System.out.println("What kind of customer are you?\n(A) Regular Customer\n(B) Member\n(C) Employee\n" +
                                "(D) Member & Employee");
                        while (true) { //third
                            String answer = input.nextLine();
                            if (answer.equalsIgnoreCase("A")) {
                                i[0] = true;
                                regularCustomer you = new regularCustomer(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("B")) {
                                i[1] = true;
                                Member you = new Member(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("C")) {
                                i[2] = true;
                                Employee you = new Employee(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("D")) {
                                i[3] = true;
                                memberEmployee you = new memberEmployee(firstName, lastName);
                            }
                            else {
                                System.out.println("Try again.");
                                continue;
                            }
                            while (true) { //fourth

                            }
                        }
                    }
                }
            }
        }
    }
}
