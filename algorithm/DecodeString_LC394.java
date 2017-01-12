/**
 * Author: Lei Zhang
 * raymond.zhang.us@gmail.com
 * Jan 12, 2017
 */
package algorithm;

import java.util.Stack;
/**
 * See problem statement at 
 * https://leetcode.com/problems/decode-string/
 * The key technology in this problem is
 * the use of stack
 * 
 * **/
public class DecodeString_LC394 {

	public static void main(String[] args) {

	}
	
	public String decodeString(String s) {
        Stack<String> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (stack.size() > 0 && Character.isDigit(stack.peek().charAt(0))) {
                    String top = stack.pop();
                    stack.push(top + ch);
                } else {
                    stack.push(ch + "");
                }
            } else if (Character.isAlphabetic(ch)){
                if (stack.size() > 0 && Character.isAlphabetic(stack.peek().charAt(0))) {
                    String top = stack.pop();
                    stack.push(top + ch);
                } else {
                    stack.push(ch + "");
                }
            } else if (ch == ']') {
                String top = stack.pop();
                stack.pop();
                int count = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder("");
                for (int k = 1; k <= count; k++) {
                    sb.append(top);
                }
                if (stack.size() > 0 && Character.isAlphabetic(stack.peek().charAt(0))) {
                    top = stack.pop();
                    stack.push(top + sb.toString());
                } else {
                    stack.push(sb.toString());
                }
            } else {
                stack.push("[");
            }
        }
        
        return stack.size() > 0 ? stack.pop() : "";
    }
}
