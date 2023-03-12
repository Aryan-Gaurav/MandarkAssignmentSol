package org.example;

import java.util.*;

/**
 * Problem 4 - Shortest Distance of Manhattan Path
 * The below image represents a grid having 11x11 nodes numbered from 0 to 10.
 * ● Distance between one node to the next connected node is 1 unit.
 * ● One can go in any direction, each letter counts as 1 unit in each direction.
 * <p>
 * ● N North
 * ● S South
 * ● E East
 * ● W West
 * <p>
 * The below graph shows the path of “NNNNEEENE” starting from (0,0)
 * <p>
 * Write a program to take
 * ● a start point as an array containing two elements as x and y coordinate, and
 * ● a string as input
 * from the user and print the shortest distance between the start and end point.
 * <p>
 * Sample Input 1
 * [0, 0]
 * NNNNEEENE
 * Output
 * 6.4 [Hint : √((4-0)2 + (5-0)2) = 6.4]
 * Sample Input 2
 * [1, 2]
 * NEWS
 * Output
 * 0
 */
public class ShortestDistance {
    public static class Point {
        Integer x;
        Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Double findDistance(Point p) {
            Double dx = x.doubleValue() - p.x.doubleValue();
            Double dy = y.doubleValue() - p.y.doubleValue();
            return Math.sqrt(dx * dx + dy * dy);
        }

        public void add(Point p) {
            x += p.x;
            y += p.y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer x = sc.nextInt();
        Integer y = sc.nextInt();
        Point originalPoint = new Point(x, y);
        Point newPoint = new Point(x, y);
        String path = sc.next();
        Map<Character, Point> shiftMap = new HashMap<>();
        shiftMap.put('N', new Point(0, 1));
        shiftMap.put('S', new Point(0, -1));
        shiftMap.put('E', new Point(1, 0));
        shiftMap.put('W', new Point(-1, 0));

        for (int i = 0; i < path.length(); i++) {
            Character direction = path.charAt(i);
            newPoint.add(shiftMap.get(direction));
        }
        System.out.printf("%.6f",originalPoint.findDistance(newPoint));
    }
}
