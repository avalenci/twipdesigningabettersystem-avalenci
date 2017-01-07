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
            }
            else {
                System.out.println("Now type in your last name.");
                while (all) { //second
                    String lastName = input.nextLine();
                    if (lastName.contains(" ")) {
                        System.out.println("No spaces please.\nTry again.");
                    }
                    else {
                        System.out.println("What kind of customer are you?\n(A) Regular Customer\n" +
                                "(B) Member\n(C) Employee\n" + "(D) Member & Employee");
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
                            while (true) { //fourth
                                System.out.println("What would you like to do " + firstName + "?\n" +
                                        "(A) Enter additional information.\n(B) Get information.\n" +
                                        "(C) Get a membership.\n(D) Exit.");
                                answer = input.nextLine();
                                if (answer.equalsIgnoreCase("A")) {
                                    System.out.println("What information would you like to give?\n" +
                                            "(A) Weight\n(B) SSN\n(C) Visits");
                                    answer = input.nextLine();
                                    if (answer.equalsIgnoreCase("A")) {
                                        System.out.println("Enter your weight in pounds please.");
                                        if (input.hasNextInt()) {
                                            you.weight = input.nextInt();
                                        }
                                    }
                                    else if (answer.equalsIgnoreCase("B")) {
                                        System.out.println("Please enter your social security number.");
                                        if (input.hasNextInt()) {
                                            you.SSN = input.nextInt();
                                        }
                                    }
                                    else if (answer.equalsIgnoreCase("C")) {
                                        System.out.println("Please enter your number of visits this month.");
                                        if (input.hasNextInt()) {
                                            you.visits = input.nextInt();
                                        }
                                    }
                                }
                                else if (answer.equalsIgnoreCase("B")) {
                                    System.out.println("What would you like to know?\n(A) Costs\n(B) Totals");
                                    answer = input.nextLine();
                                    if (answer.equalsIgnoreCase("A")) {
                                        System.out.println("What would you like to know the cost of?\n" +
                                                "(A) Membership\n(B) Classes\n(C) Retail Discount\n(D) Aquatics\n" +
                                                "(E) Personal Trainer");
                                        answer = input.nextLine();
                                        if (answer.equalsIgnoreCase("A")) {
                                            if (you.membership == 1) {
                                                System.out.println("Membership costs a one time" + " payment " +
                                                        "of 1 dollar as long as you are an employee.\n");
                                            } else if (you.membership == 0)
                                                System.out.println("You are already a member.\n");
                                            else
                                                System.out.println("Membership costs $65 per month.\n");
                                        } else if (answer.equalsIgnoreCase("B")) {
                                            System.out.println("Classes cost $" + you.classes +
                                                    " per class.\n");
                                        } else if (answer.equalsIgnoreCase("C")) {
                                            if (you.retail == 0)
                                                System.out.println("You do not apply for a discount.\n");
                                            else
                                                System.out.println("You get " + you.retail +
                                                        "% off at the shop.\n");
                                        } else if (answer.equalsIgnoreCase("D")) {
                                            if (you.aquatics == 0)
                                                System.out.println("You do not apply for aquatics.\n");
                                            else
                                                System.out.println("Aquatics cost $" + you.aquatics + ".\n");
                                        } else if (answer.equalsIgnoreCase("E")) {
                                            System.out.println("A personal trainer costs $" +
                                                    you.trainer + ".\n");
                                        } else {
                                            break;
                                        }
                                    }
                                    else if (answer.equalsIgnoreCase("B")) {
                                        System.out.println("This month you will be charged $" + you.bill + ".\n");
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
                                        you.bill += 65;
                                        System.out.println("Congratulations! You are now a member.\n");
                                    }
                                    else if (i[2]) { //Employee
                                        you.membership = 0;
                                        you.retail = 20;
                                        i[2] = false;
                                        i[3] = true;
                                        you.bill += 1;
                                        System.out.println("Congratulations! You are now a member.\n");
                                    }
                                    else {
                                        System.out.println("You are already a member.\nPlease pick another option.");
                                    }
                                }
                                else if (answer.equalsIgnoreCase("D")) {
                                    all = false;
                                    break;
                                }
                                else {
                                    System.out.println("Try again.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
