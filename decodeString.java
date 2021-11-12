//Given an encoded string, return its decoded string.
//
//        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//
//        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//        Example 1:
//        Input: s = "3[a]2[bc]"
//        Output: "aaabcbc"
//
//
//        Example 2:
//        Input: s = "3[a2[c]]"
//        Output: "accaccacc"
//
//        Example 3:
//        Input: s = "2[abc]3[cd]ef"
//        Output: "abcabccdcdcdef"
//
//        Example 4:
//        Input: s = "abc3[cd]xyz"
//        Output: "abccdcdcdxyz"

import java.util.Stack;

public class mtest {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String a = decodeString(s);
        System.out.println(a);
    }

    private static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != ']') {
                stack.push(Character.toString(s.charAt(i)));
            } else {
                StringBuilder test = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    String ch = stack.pop();
                    test.append(ch);
                }
                stack.pop();
                int n = Integer.parseInt(stack.pop());
                StringBuilder res= new StringBuilder();
                while(n > 0) {
                    n--;
                    res.append(test);
                }
                stack.push(res.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}
