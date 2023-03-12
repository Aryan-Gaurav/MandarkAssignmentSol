package org.example;

import java.util.Scanner;

/**
 * Problem 1 - Swapping Min Max
 * You are given two lists a and b of n positive integers each. You can apply the following
 * swap operations to them any number of times.
 * Select an index i (1 <= i <= n) and swap ai with bi (i.e. ai becomes bi and vice versa).
 * Write a function minmax(a,b) which takes two lists a and b of size n as inputs and
 * returns an integer, which is the minimum possible value of max(a1, a2, ..., a ) x max(b1,
 * b2, ..., b ) you can get after applying the swap operation any number of times (possibly
 * zero).
 * <p>
 * Example - Consider that the list starts with index 0
 * Consider the lists : a = [1, 2, 6, 5, 1, 2] and
 * b = [3, 4, 3, 2, 2, 5]
 * <p>
 * In this case, you can apply the swap operation at indices 1 (between 2 and 4) and
 * 5 (between 2 and 5),
 * then a = [1, 4, 6, 5, 1, 5] and b = [3, 2, 3, 2, 2, 2]
 * and max(1, 4, 6, 5, 1, 5) x max (3, 2, 3, 2, 2, 2) = 6 x 3 = 18
 * <p>
 * Sample Input 1
 * 6
 * 1 2 6 5 1 2
 * 3 4 3 2 2 5
 * Output
 * 18
 * Sample Input 2
 * 25
   8 7 9 6 5 6 6 5 6 4 6 7 8 5 4 3 2 1 4 5 6 7 8 7 8
   2 4 5 6 7 6 7 8 9 8 7 6 7 6 5 4 3 2 3 4 5 5 5 4 5
 * Output
 * 63
 * <p>
 * Sample Input 3
 * 12
  1 2 3 2 3 4 5 3 5 6 7 8
  2 1 5 3 4 6 4 3 2 3 1 2
 * Output
 * 32
 */
public class SwappingMinMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Integer maxA = Integer.MIN_VALUE;
        Integer maxB = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                int t = a[i];
                a[i] = b[i];
                b[i] = t;
            }
            maxA = Math.max(maxA, a[i]);
            maxB = Math.max(maxB, b[i]);
        }
        System.out.println(maxA.longValue() * maxB.longValue());

    }
}
