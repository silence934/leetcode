package xyz.nyist.bfs;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/25 17:45
 */

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    static char[][] M = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', '#', 'E', '#', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};  //x方向
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};//y方向
    public static Point start = null;
    public static Point end = null;

    public static void main(String[] args) {
        //获取起始点和结束点
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (M[i][j] == 'S') {
                    start = new Point(j, i);
                }
                if (M[i][j] == 'E') {
                    end = new Point(j, i);
                }
            }
        }
        //开始遍历
        bfs();
        //从结束点开始打印出路径
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }

    /////////////广度优先部分,主要寻路在这里//////////
    public static void bfs() {
        //队列进行记录待遍历的点
        Queue<Point> queue = new LinkedList<>();
        //将起始点加入队列
        queue.add(start);
        //设置与地图等大的MyMap
        MyMap[][] my = new MyMap[10][10];
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                my[m][n] = new MyMap();
            }
        }
        //开始遍历
        while (queue.size() > 0) {
            //队列头进行遍历
            Point p = queue.poll();
            //8个方向
            for (int i = 0; i < 8; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && M[ny][nx] != '#') {
                    //第一次访问
                    if (my[ny][nx].getPrice() == 0) {
                        queue.add(new Point(nx, ny));
                        if ((dx[i] == -1 && dy[i] == -1) || (dx[i] == -1 && dy[i] == 1) || (dx[i] == 1 && dy[i] == -1) || (dx[i] == 1 && dy[i] == 1)) {
                            my[ny][nx].setPrice(my[p.getY()][p.getX()].getPrice() + 14);
                        }
                        else {
                            my[ny][nx].setPrice(my[p.getY()][p.getX()].getPrice() + 10);
                        }
                        my[ny][nx].setPreX(p.getX());
                        my[ny][nx].setPreY(p.getY());

                    }
                    else {
                        //二次访问不用加入队列，
                        if ((dx[i] == -1 && dy[i] == -1) || (dx[i] == -1 && dy[i] == 1) || (dx[i] == 1 && dy[i] == -1) || (dx[i] == 1 && dy[i] == 1)) {
                            if (my[p.getY()][p.getX()].getPrice() + 14 <= my[ny][nx].getPrice()) {
                                my[ny][nx].setPrice(my[p.getY()][p.getX()].getPrice() + 14);
                                my[ny][nx].setPreX(p.getX());
                                my[ny][nx].setPreY(p.getY());
                            }
                        }
                        else {
                            if (my[p.getY()][p.getX()].getPrice() + 10 < my[ny][nx].getPrice()) {
                                my[ny][nx].setPrice(my[p.getY()][p.getX()].getPrice() + 10);
                                my[ny][nx].setPreX(p.getX());
                                my[ny][nx].setPreY(p.getY());
                            }
                        }
                    }


                }

            }

            //////////////////以下部分只是打印不重要//////////////////
            //到达目的地后
            if (p.getX() == end.getX() && p.getY() == end.getY()) {
                int x = p.getX();
                int y = p.getY();
                int tmpx = 0;
                int tmpy = 0;
                //打印
                while (x != start.getX() || y != start.getY()) {
                    tmpx = my[y][x].getPreX();
                    tmpy = my[y][x].getPreY();
                    x = tmpx;
                    y = tmpy;
                    if (M[y][x] != 'S') {
                        M[y][x] = '*';
                    }
                }
                break;
            }
        }
    }
}
