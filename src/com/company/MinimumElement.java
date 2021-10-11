package com.company;

import java.util.Scanner;

public class MinimumElement {
//    Write a method called readInteger() that has no parameters and returns an int.
//    It needs to read in an integer from the user - this represents how many elements the user needs to enter.
//    Write another method called readElements() that has one parameter of type int
//    The method needs to read from the console until all the elements are entered, and then return an array containing
//    the elements entered.
//    And finally, write a method called findMin() with one parameter of type int[]. The method needs to return the
//    minimum value in the array.
//
//    The scenario is:
//            1. readInteger() is called.
//            2. The number returned by readInteger() is then used to call readElements().
//            3. The array returned from readElements() is used to call findMin().
//            4. findMin() returns the minimum number.

    public static void main(String[] args) {
        int userInput = readInteger();
        int[] userArray = readElements(userInput);
        System.out.println(findMin(userArray));
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers should i process?");
        int userInput = scanner.nextInt();
        return userInput;
    }

    private static int[] readElements(int amount) {
        Scanner scanner = new Scanner(System.in);
        int[] resultArray = new int[amount];
        System.out.println("Please enter " + amount + " integers into the console:");

        for (int i = 0; i < amount; i++) {
            resultArray[i] = scanner.nextInt();
        }

        return resultArray;
    }

    private static int findMin(int[] array) {
        int minValue = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        System.out.println("The lowest value in this array is: " + minValue);
        return minValue;
    }
}
