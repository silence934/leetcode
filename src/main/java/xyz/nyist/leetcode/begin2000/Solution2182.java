package xyz.nyist.leetcode.begin2000;

public class Solution2182 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 77);
        System.out.println(sb.toString());
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 127; i > 0; i--) {

            while (arr[i] > 0) {
                int t = Math.min(arr[i], repeatLimit);
                arr[i] -= t;

                for (int j = 0; j < t; j++) {
                    sb.append((char) i);
                }

                if (arr[i] > 0) {
                    int j = i - 1;
                    for (; j > 0; j--) {
                        if (arr[j] > 0) {
                            arr[j]--;
                            sb.append((char) j);
                            break;
                        }
                    }
                    if (j == 0) {
                        return sb.toString();
                    }
                }
            }

        }


        return sb.toString();
    }
}
