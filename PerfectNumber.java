package org.example;

import java.util.Scanner;

public class PerfectNumber {

    /**
     * Problem 5 - Perfect Number
     * A perfect number is a positive integer that is equal to the sum of its proper divisors
     * (excluding itself). Write a program that checks whether the input integer is perfect or not.
     * It should return true if the number is perfect. Otherwise it should return false.
     * Sample Input 1
     * 8
     * Output
     * false
     * Sample Input 2
     * 28
     * Output
     * true
     * Sample Input 3
     * 496
     * Output
     * true
     */
    private static boolean isPerfect(Integer number) {
        Integer sumOfDivisors = 0;
        for (int smallerDivisor = 1; smallerDivisor * smallerDivisor <= number; smallerDivisor++) {
            if (number % smallerDivisor == 0) {
                sumOfDivisors += smallerDivisor;
                Integer biggerDivisor = number / smallerDivisor;
                if (biggerDivisor != smallerDivisor && biggerDivisor < number) {
                    sumOfDivisors += biggerDivisor;
                }
            }
        }
        boolean isPerfectNumber = sumOfDivisors.equals(number);
        return isPerfectNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        System.out.println(isPerfect(number));
    }
}
