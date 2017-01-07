package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean i[] = new boolean[4];
        boolean all = true;
        System.out.println("Greetings! Please type in your first name.");
        Scanner input = new Scanner(System.in);
        while (all) { //first
            String firstName = input.nextLine();
            if (firstName.contains(" ")) {
                System.out.println("No spaces please.\nTry again.");
                continue;
            }
            else {
                System.out.println("Now type in your last name.");
                while (all) { //second
                    String lastName = input.nextLine();
                    if (lastName.contains(" ")) {
                        System.out.println("No spaces please.\nTry again.");
                        continue;
                    }
                    else {
                        System.out.println("What kind of customer are you?\n(A) Regular Customer\n(B) Member\n(C) Employee\n" +
                                "(D) Member & Employee");
                        while (all) { //third
                            String answer = input.nextLine();
                            Customer you;
                            if (answer.equalsIgnoreCase("A")) {
                                i[0] = true; //Regular Customer
                                you = new regularCustomer(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("B")) {
                                i[1] = true; //Member
                                you = new Member(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("C")) {
                                i[2] = true; //Employee
                                you = new Employee(firstName, lastName);
                            }
                            else if (answer.equalsIgnoreCase("D")) {
                                i[3] = true; //Member & Employee
                                you = new memberEmployee(firstName, lastName);
                            }
                            else {
                                System.out.println("Try again.");
                                continue;
                            }
                            System.out.println("What would you like to do " + firstName + "?\n" +
                                    "(A) Enter additional information.\n(B) Get information.\n(C) Get a membership.\n(D) Exit.");
                            while (all) { //fourth
                                answer = input.nextLine();
                                if (answer.equalsIgnoreCase("A"));
                                else if (answer.equalsIgnoreCase("B")) {
                                    System.out.println("What would you like to know?\n(A) Costs\n(B) Totals");
                                    while (all) { //fifth
                                        answer = input.nextLine();
                                        if (answer.equalsIgnoreCase("A")) {
                                            System.out.println("What would you like to know the cost of?\n" +
                                                    "(A) Membership\n(B) Classes\n(C) Retail Discount\n(D) Aquatics\n" +
                                                    "(E) Personal Trainer");
                                            while (all) { //sixth

                                            }
                                        }
                                        else if (answer.equalsIgnoreCase("B"));
                                        else {
                                            System.out.println("Try again.");
                                            continue;
                                        }
                                        break;
                                    }
                                }
                                else if (answer.equalsIgnoreCase("C")) {
                                    if (i[0]) { //Regular Customer
                                        you.membership = 0;
                                        you.classes = 8;
                                        you.retail = 20;
                                        you.aquatics = 10;
                                        you.trainer = 20;
                                        i[0] = false;
                                        i[1] = true;
                                    }
                                    else if (i[2]) { //Employee
                                        you.membership = 0;
                                        you.retail = 20;
                                        i[2] = false;
                                        i[3] = true;
                                    }
                                    else {
                                        System.out.println("You are already a member.\nPlease pick another option.");
                                        continue;
                                    }
                                }
                                else if (answer.equalsIgnoreCase("D")) {
                                    all = false;
                                    break;
                                }
                                else {
                                    System.out.println("Try again.");
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
