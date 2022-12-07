package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Deque;
import java.util.LinkedList;

public class BalanceWorld implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        String result = "";
        while (true) {
            s = br.readLine();
            if (s.equals(".")) break;
            result = "yes";
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[')
                    stack.push(s.charAt(i));
                else if (s.charAt(i) == ')') {
                    if (stack.peek() == null || stack.pop() != '(') {
                        result = "no";
                        break;
                    }
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == null || stack.pop() != '[') {
                        result = "no";
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) result = "no";
            bw.write(result + "\n");
        }
        bw.close();
    }
}
