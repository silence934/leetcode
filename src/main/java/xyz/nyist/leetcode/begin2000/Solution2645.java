package xyz.nyist.leetcode.begin2000;

public class Solution2645 {
    public int addMinimum(String word) {
        int res = 0;

        if (word.charAt(0) == 'b') {
            res = res + 1;
        } else if (word.charAt(0) == 'c') {
            res = res + 2;
        }

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            char pre = word.charAt(i - 1);

            switch (c) {
                case 'a': {
                    switch (pre) {
                        case 'a': {
                            res = res + 2;
                            break;
                        }
                        case 'b': {
                            res = res + 1;
                            break;
                        }
                        case 'c': {
                            break;
                        }
                    }
                    break;
                }
                case 'b': {
                    switch (pre) {
                        case 'a': {
                            break;
                        }
                        case 'b': {
                            res = res + 2;
                            break;
                        }
                        case 'c': {
                            res = res + 1;
                            break;
                        }
                    }
                    break;
                }
                case 'c': {
                    switch (pre) {
                        case 'a': {
                            res = res + 1;
                            break;
                        }
                        case 'b': {
                            break;
                        }
                        case 'c': {
                            res = res + 2;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        if (word.charAt(word.length() - 1) == 'a') {
            res = res + 2;
        } else if (word.charAt(word.length() - 1) == 'b') {
            res = res + 1;
        }


        return res;
    }
}
