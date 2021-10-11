package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
//    Create a program using arrays that sorts a list of integers in descending order.
//    Descending order is highest value to lowest.
//    In other words if the array had the values in it [106, 26, 81, 5, 15] your program should ultimately have an
//    array with [106, 81, 26, 15, 5] in it.
//
//    Set up the program so that the numbers to sort are read in from the keyboard (Scanner).
//
//    Implement the following methods:
//    getIntegers has one parameter of type int which is the size of the array. It returns an array of entered integers from the keyboard.
//    printArray accepts an array and prints out the contents of the array. It should be printed in the following format:
//        Element 0 contents 106
//        Element 1 contents 81
//        Element 2 contents 26
//        Element 3 contents 15
//        Element 4 contents 5
//    sortIntegers accepts the unsorted array. It should sort the array and return a new array containing the sorted numbers.

    public static void main(String[] args) {
        int[] unsortedArray = getIntegers(5);
        int [] sortedInReverse = sortIntegers(unsortedArray);
        printArray(sortedInReverse);
    }

    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type in " + size + " numbers.");

        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = scanner.nextInt();
        }

        System.out.println("Thank you, please wait ...");

        return resultArray;
    }

    public static int[] sortIntegers(int[] unsortedArray) {
        Arrays.sort(unsortedArray);

        int[] reversedOrderArray = new int[unsortedArray.length];

        int indexForUnsorted = unsortedArray.length - 1;
        int indexForSorted = 0;
        while (indexForUnsorted >= 0) {
            reversedOrderArray[indexForSorted] = unsortedArray[indexForUnsorted];
            indexForUnsorted--;
            indexForSorted++;
        }

        return reversedOrderArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}
