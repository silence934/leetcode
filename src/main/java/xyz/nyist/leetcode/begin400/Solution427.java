package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
 * @Date: 2022/4/29 10:29
 * @Description:
 */
public class Solution427 {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }


    private Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return new Node(grid[x1][y1] == 1, true);
        } else {
            Node topLeft = construct(grid, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
            Node topRight = construct(grid, x1, (y1 + y2) / 2 + 1, (x1 + x2) / 2, y2);
            Node bottomLeft = construct(grid, (x1 + x2) / 2 + 1, y1, x2, (y1 + y2) / 2);
            Node bottomRight = construct(grid, (x1 + x2) / 2 + 1, (y1 + y2) / 2 + 1, x2, y2);
            boolean isAllLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
            if (isAllLeaf
                    && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true);
            } else {
                return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
    }

    private static class Node {

        public boolean val;

        public boolean isLeaf;

        public Node topLeft;

        public Node topRight;

        public Node bottomLeft;

        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

    }

}
