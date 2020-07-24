package xyz.nyist.arithmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/26 18:47
 */
public class Main2 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0], k = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                k = i;
            }
        }
        return min;
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        else if (target == 2) {
            return 2;
        }
        int[] a = new int[target];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < target; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[target - 1];
    }

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int[] a = new int[target];
        a[0] = 1;
        for (int i = 1; i < target; i++) {
            a[i] = 2 * a[i - 1];
        }
        return a[target - 1];
    }

    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        else if (target == 2) {
            return 2;
        }
        else {
            return RectCover(target - 1) + RectCover(target - 2);
        }

    }

    public int NumberOf1(int n) {
        char[] a = Integer.toBinaryString(n).toCharArray();
        int i = 0;
        for (char c : a) {
            if (c == '1') {
                i++;
            }
        }
        return i;
    }

    public double Power(double base, int exponent) {
        double res = base;
        for (int i = 0; i < Math.abs(exponent) - 1; i++) {
            res *= base;
        }
        if (exponent < 0) {
            res = 1D / res;
        }
        return res;
    }

    public int cutRope(int target) {
        if (target <= 3) {
            return target - 1;
        }
        int m = target / 3;
        int n = target % 3;
        if (n == 1) {
            m--;
            n = 4;
        }
        else if (n == 0) {
            n = 1;
        }

        return (int) Math.pow(3, m) * n;
    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] map = new int[rows][cols];
        int res = 0;
        class Element {
            int x;
            int y;

            public Element(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        if (threshold >= 0) {
            res++;
            Queue<Element> queue = new LinkedList<>();
            map[0][0] = 1;
            queue.add(new Element(0, 0));
            while (!queue.isEmpty()) {
                Element element = queue.poll();
                if (element.x + 1 < rows && map[element.x + 1][element.y] == 0 && canArrive(threshold, element.x + 1, element.y)) {
                    res++;
                    map[element.x + 1][element.y] = 1;
                    queue.add(new Element(element.x + 1, element.y));
                }
                if (element.x - 1 >= 0 && map[element.x - 1][element.y] == 0 && canArrive(threshold, element.x - 1, element.y)) {
                    res++;
                    map[element.x - 1][element.y] = 1;
                    queue.add(new Element(element.x - 1, element.y));
                }
                if (element.y + 1 < cols && map[element.x][element.y + 1] == 0 && canArrive(threshold, element.x, element.y + 1)) {
                    res++;
                    map[element.x][element.y + 1] = 1;
                    queue.add(new Element(element.x, element.y + 1));
                }
                if (element.y - 1 >= 0 && map[element.x][element.y - 1] == 0 && canArrive(threshold, element.x, element.y - 1)) {
                    res++;
                    map[element.x][element.y - 1] = 1;
                    queue.add(new Element(element.x, element.y - 1));
                }
            }
        }
        return res;
    }

    public boolean canArrive(int threshold, int x, int y) {
        char[] s = (String.valueOf(x) + y).toCharArray();
        int res = 0;
        for (char c : s) {
            res = res + Integer.parseInt(String.valueOf(c));
        }
        //System.out.println("(" + x + "," + y + ")" + res + ":" + (res <= threshold));
        return res <= threshold;
    }


    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str) {
        class Element {
            char c;
            int b;

            public Element(char c, int b) {
                this.c = c;
                this.b = b;
            }

            @Override
            public String toString() {
                return "(" + c + "," + b + ')';
            }
        }
        class Point {
            int x;
            int y;
            int j;

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
                        '}';
            }
        }
        Stack<Point> stack = new Stack<>();
        Element[][] map = new Element[rows][cols];
        int t = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[t] == str[0]) {
                    stack.push(new Point(i, j, 0));
                }
                map[i][j] = new Element(matrix[t++], 0);
            }
        }

        System.out.println(stack);
        int length = str.length;
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            //System.out.println(point);
            if (point.j + 1 == length) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(map[i][j] + " ");
                    }
                    System.out.println();
                }
                return true;
            }
            map[point.x][point.y].b = 1;
            boolean b = false;
            if (point.x + 1 < rows && map[point.x + 1][point.y].b != 1 && map[point.x + 1][point.y].c == str[point.j + 1]) {
                stack.push(new Point(point.x + 1, point.y, point.j + 1));
                b = true;
            }
            if (point.x - 1 > -1 && map[point.x - 1][point.y].b != 1 && map[point.x - 1][point.y].c == str[point.j + 1]) {
                stack.push(new Point(point.x - 1, point.y, point.j + 1));
                b = true;
            }
            if (point.y + 1 < cols && map[point.x][point.y + 1].b != 1 && map[point.x][point.y + 1].c == str[point.j + 1]) {
                stack.push(new Point(point.x, point.y + 1, point.j + 1));
                b = true;
            }
            if (point.y - 1 > -1 && map[point.x][point.y - 1].b != 1 && map[point.x][point.y - 1].c == str[point.j + 1]) {
                stack.push(new Point(point.x, point.y - 1, point.j + 1));
                b = true;
            }
            if (!b) {
                map[point.x][point.y].b = 0;
            }
        }
        return false;
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols
                || str == null || str.length == 0
                || str.length > matrix.length) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {//每个节点都有可能是起点
                if (dfs(matrix, rows, cols, str, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    //这里方便遍历上下左右
    private static int[] x = {0, 1, 0, -1};//顺时针
    private static int[] y = {1, 0, -1, 0};//顺时针

    //这里复用了boolean[] visited 减少内存开销
    private boolean dfs(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] visited) {
        if (matrix[i + j * cols] != str[0]) {
            return false;//第一个字符必须相等
        }
        Stack<Integer> s = new Stack<>();//存的是坐标
        int index = 0;//当前str的索引
        s.push(i + j * cols);
        while (!s.empty()) {
            int location = s.peek();
            if (visited[location]) {//访问过,全部复位
                visited[location] = false;//取消访问记录
                s.pop();//退出该节点
                if (--index < 0) {
                    return false;
                }
                continue;//防止该路径再次遍历
            }
            visited[location] = true;//标记已访问
            if (++index == str.length) {
                return true;//如果这个字符恰好是最后一个字符，直接返回true
            }

            /*
             * 将当前节点周围(上下左右)符合标准的点加入到s中,
             * 1.边界条件：i = location % cols  j = location / cols i和j判断边界
             * 2.必须未遍历过visited[cur] == false
             * 3.当前字符匹配matrix[cur] == str[index]
             */
            for (int k = 0; k < 4; k++) {
                int xn = location % cols + x[k];
                int yn = location / cols + y[k];
                int cur = xn + yn * cols;
                if (xn >= 0 && xn < cols && yn >= 0
                        && yn < rows && visited[cur] == false
                        && matrix[cur] == str[index]) {
                    s.push(cur);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.hasPath1("abcdhgfecccfjihg".toCharArray(), 4, 4, "abcdefgcf".toCharArray()));
       /*
        main2.push(1);
        main2.push(2);
        main2.push(3);
        main2.push(4);
        main2.push(5);
       System.out.println(main2.pop());
        System.out.println(main2.pop());
        System.out.println(main2.pop());*/
    }
}
