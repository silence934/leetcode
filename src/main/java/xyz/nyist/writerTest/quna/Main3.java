package xyz.nyist.writerTest.quna;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author: silence
 * @Date: 2021/4/12 18:58
 * @Description:
 */
public class Main3 {
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        List<Node> list = new ArrayList<>();
        for (String str : split) {
            Node index = new Node(str);
            Iterator<Node> iterator = list.iterator();

            boolean isAdd = true;

            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (node.start.isAfter(index.end) || node.end.isBefore(index.start)) {
                    //不相关
                } else if (node.start.isBefore(index.start) && node.end.isAfter(index.end)) {
                    //node包含index
                    if (node.price.equals(index.price)) {
                        isAdd = false;
                    } else {
                        Node node1 = new Node(node.start, index.start, node.price);
                        Node node2 = new Node(index.end, node.end, node.price);
                        iterator.remove();
                        list.add(node1);
                        list.add(node2);
                    }
                    break;
                } else if (index.start.isBefore(node.start) && index.end.isAfter(node.end)) {
                    //index包含node
                    iterator.remove();
                } else if (node.end.isAfter(index.start) && node.end.isBefore(index.end)) {
                    //node左包含index
                    node.end = index.start;
                } else if (node.start.isBefore(index.end) && node.start.isAfter(index.start)) {
                    //node右包含index
                    node.start = index.end;
                } else if (node.end.equals(index.start) && node.price.equals(index.price)) {
                    iterator.remove();
                    index.start = node.start;
                } else if (node.start.equals(index.end) && node.price.equals(index.price)) {
                    iterator.remove();
                    index.end = node.end;
                }
            }
            if (isAdd) {
                list.add(index);
            }
        }

        Collections.sort(list);

        for (Node node : list) {
            System.out.println(node);
        }
    }


    static class Node implements Comparable<Node> {
        LocalDate start;
        LocalDate end;
        Integer price;

        public Node(String str) {
            String[] split = str.split("~");
            String[] split1 = split[1].split(":");
            this.start = LocalDate.parse(split[0], dateFormatter);
            this.end = LocalDate.parse(split1[0], dateFormatter);
            this.price = Integer.parseInt(split1[1]);
        }

        public Node(LocalDate start, LocalDate end, Integer price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            if (this.price.equals(o.price)) {
                if (this.start.isAfter(o.start)) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.price > o.price) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return start + "~" + end + ":" + price;
        }
    }
}
