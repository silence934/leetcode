package xyz.nyist.leetcode.begin1800;

public class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] split1 = sentence1.split(" ");
        String[] split2 = sentence2.split(" ");


        if (split1.length < split2.length) {
            String[] split3 = split1;
            split1 = split2;
            split2 = split3;
            String s = sentence1;
            sentence1 = sentence2;
            sentence2 = s;
        }

//        if (sentence1.startsWith(sentence2) || sentence1.endsWith(sentence2)) {
//            return true;
//        }
//
//        if (!split1[0].equals(split2[0]) || !split1[split1.length - 1].equals(split2[split2.length - 1])) {
//            return false;
//        }

        int i = 0;
        for (; i < split2.length; i++) {
            if (!split1[i].equals(split2[i])) {
                break;
            }
        }

        for (; i < split2.length; i++) {
            if (!split1[split1.length - split2.length + i].equals(split2[i])) {
                return false;
            }
        }


        return true;
    }
}
