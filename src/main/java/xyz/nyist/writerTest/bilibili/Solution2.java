package xyz.nyist.writerTest.bilibili;

import java.util.Stack;

/**
 * @Author : fucong
 * @Date: 2020-08-13 19:23
 * @Description :
 */
public class Solution2 {
    //([{

    public boolean IsValidExp (String s) {
        if (s==null|| "".equals(s)){
            return true;
        }
        char[] ch=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]==' '){
                continue;
            }
            if (ch[i]=='('||ch[i]=='{'||ch[i]=='['){
                stack.add(ch[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char c=stack.pop();
                if (ch[i]==')'&&c!='('){
                    return false;
                }
                else if (ch[i]=='}'&&c!='{'){
                    return false;
                }
                else if (ch[i]==']'&&c!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution2 solution1=new Solution2();
        System.out.println(solution1.IsValidExp("({})]"));
    }
}
