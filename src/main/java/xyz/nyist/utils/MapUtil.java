package xyz.nyist.utils;

import xyz.nyist.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/24 18:11
 */
public class MapUtil {


    /**
     * 获取无向无环图（有权值）
     */
    public static List<List<Element>> productUAG() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Element>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
            lst = map.get(y);
            lst.add(new Element(x1, l));
        }
        return map;
    }

    /**
     * 获取有向无环图（有权值）
     */
    public static List<List<Element>> productDAG() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Element>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
        }
        return map;
    }

    /**
     * 获取有向图（有权值）
     */
    public static List<List<Element>> productDirected() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        List<List<Element>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < s; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
        }
        return map;
    }

    /**
     * 获取无向图（有权值）
     */
    public static List<List<Element>> productUnDirected() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        List<List<Element>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < s; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
            lst = map.get(y);
            lst.add(new Element(x1, l));
        }
        return map;
    }

}
