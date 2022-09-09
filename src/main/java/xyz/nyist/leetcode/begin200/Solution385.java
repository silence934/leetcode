package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/4/15 10:26
 * @Description:
 */
public class Solution385 {


    public static void main(String[] args) {
        for (String s : "123,[456,[789]]".split(",(?!\\[)")) {
            System.out.println(s);
        }
    }

    public NestedInteger deserialize(String s) {

        if (s.startsWith("[")) {
            NestedInteger nestedInteger = new NestedInteger() {
                @Override
                public boolean isInteger() {
                    return false;
                }
            };
            s = s.substring(1, s.length() - 1);

            List<Integer> indexs = new ArrayList<>();
            int brackets = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    brackets++;
                } else if (c == ']') {
                    brackets--;
                } else if (c == ',' && brackets == 0) {
                    indexs.add(i);
                }
            }

            int start = 0;

            for (Integer index : indexs) {
                String str = s.substring(start, index);
                if (!"".equals(str)) {
                    nestedInteger.add(deserialize(str));
                }
                start = index + 1;
            }
            String str = s.substring(start);
            if (!"".equals(str)) {
                nestedInteger.add(deserialize(str));
            }
            return nestedInteger;
        } else {
            return new NestedInteger(Integer.parseInt(s)) {
                @Override
                public boolean isInteger() {
                    return true;
                }
            };
        }
    }


    public abstract class NestedInteger {

        // Constructor initializes an empty nested list.

        private List<NestedInteger> nestedIntegers;

        private int value;

        public NestedInteger() {
            nestedIntegers = new ArrayList<>();
        }

        // Constructor initializes a single integer.

        public NestedInteger(int value) {
            this.value = value;
            this.nestedIntegers = new ArrayList<>();
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public abstract boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            nestedIntegers.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedIntegers;
        }

    }

}
