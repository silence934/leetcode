package xyz.nyist.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/5 10:36
 */
public class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        BigInteger[] res = new BigInteger[n + 1];
        res[0] = new BigInteger("0");
        res[1] = new BigInteger("1");
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1].add(res[i - 2]);
        }
        return (res[n].remainder(new BigInteger("1000000007"))).intValue();
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        BigInteger[] res = new BigInteger[n + 1];
        res[0] = new BigInteger("1");
        res[1] = new BigInteger("1");
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1].add(res[i - 2]);
        }
        return (res[n].remainder(new BigInteger("1000000007"))).intValue();
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    static class Point {
        int x, y, j;

        public Point(int x, int y, int j) {
            this.x = x;
            this.y = y;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", j=" + j +
                    '}';
        }
    }

    static class Element {
        char c;
        boolean b;

        public Element(char c, boolean b) {
            this.c = c;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + c + "," + b + ')';
        }
    }

    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        List<Point> list = new ArrayList<>();
        Element[][] map = new Element[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == str[0]) {
                    list.add(new Point(i, j, 0));
                }
                map[i][j] = new Element(board[i][j], true);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (Point point : list) {
            if (aa(point, map, str)) {
                return true;
            }
        }
        return false;
    }

    public boolean aa(Point point, Element[][] map, char[] str) {
        map[point.x][point.y].b = false;
        if (point.j + 1 == str.length) {
            System.out.println();
            for (Element[] elements : map) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(elements[j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if (point.y + 1 < map[0].length && map[point.x][point.y + 1].b && map[point.x][point.y + 1].c == str[point.j + 1]) {
            if (aa(new Point(point.x, point.y + 1, point.j + 1), map, str)) {
                return true;
            }
        }
        if (point.y - 1 > -1 && map[point.x][point.y - 1].b && map[point.x][point.y - 1].c == str[point.j + 1]) {
            if (aa(new Point(point.x, point.y - 1, point.j + 1), map, str)) {
                return true;
            }
        }
        if (point.x + 1 < map.length && map[point.x + 1][point.y].b && map[point.x + 1][point.y].c == str[point.j + 1]) {
            if (aa(new Point(point.x + 1, point.y, point.j + 1), map, str)) {
                return true;
            }
        }
        if (point.x - 1 > -1 && map[point.x - 1][point.y].b && map[point.x - 1][point.y].c == str[point.j + 1]) {
            if (aa(new Point(point.x - 1, point.y, point.j + 1), map, str)) {
                return true;
            }
        }
        map[point.x][point.y].b = true;
        return false;
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        char[][] board = {{'A', 'B', 'C', 'D'}, {'H', 'G', 'F', 'E'}, {'C', 'C', 'C', 'F'}, {'J', 'I', 'H', 'G'}};
        String word = "ABCDEFGHCF";

        System.out.println(obj.exist(board, word));
    }
}
