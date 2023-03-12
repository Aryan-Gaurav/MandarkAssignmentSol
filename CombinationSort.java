package org.example;

import java.util.*;

/**
 * Write a program that takes a list of unique strings as an argument, where each string is
 * a combination of a letter from a - z and a number from 0 - 99 , the initial character in
 * string being the letter. For example a23, d5, z0, q99 are some strings in this format. The
 * program should sort the list and return the lists L1 and L2 in the order mentioned below.
 * L1 : First list should contain all strings sorted in ascending order with respect to the first
 * character only. All the strings with the same initial character should be in the same order
 * as in the original list.
 * L2 : In the list L1 above, sort the strings starting with the same character, in descending
 * order with respect to the number formed by the remaining characters.
 * Sample Input 1
 * d34, g54, d12, b87, g1, c65, g40, g5, d77
 * Output
 * L1 : b87, c65, d34, d12, d77, g54, g1, g40, g5
 * L2 : b87, c65, d77, d34, d12, g54, g40, g5, g1
 */
public class CombinationSort {
    private static int getNumber(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans *= 10;
            ans += s.charAt(i) - '0';
        }
        return ans;
    }

    private static int isFirstCharacterSame(String s, String t) {
        Character x = s.charAt(0);
        Character y = t.charAt(0);
        if (x < y) {
            return -1;
        }
        if (x > y) {
            return 1;
        }
        return 0;
    }

    public static class firstCharcterComparator implements Comparator<String> {

        @Override
        public int compare(String s, String t) {
            return isFirstCharacterSame(s, t);
        }
    }

    public static class firstCharThenNumComparator implements Comparator<String> {
        @Override
        public int compare(String s, String t) {
            int result = isFirstCharacterSame(s, t);
            if (result != 0) {
                return result;
            }
            int a = getNumber(s);
            int b = getNumber(t);
            if (a > b) {
                return -1;
            }
            if (a < b) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr.add(s);
        }
        Collections.sort(arr, new firstCharcterComparator());
        System.out.print("L1 : ");
        for (String s : arr)
            System.out.print(s + " ");
        System.out.print("\n");
        Collections.sort(arr, new firstCharThenNumComparator());
        System.out.print("L2 : ");
        for (String s : arr)
            System.out.print(s + " ");
        System.out.print("\n");
    }
}
