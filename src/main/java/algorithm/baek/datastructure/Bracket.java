package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bracket implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Character> deque;
        for (int i = 0; i < n; i++) {
            deque = new ArrayDeque<>();
            String s = br.readLine();
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    deque.addFirst(c);
                } else {
                    if (deque.isEmpty()) {
                        bw.write("NO");
                        bw.newLine();
                        flag = false;
                        break;
                    } else {
                        if(deque.pollFirst()!='('){
                            bw.write("NO");
                            bw.newLine();
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                bw.write(deque.isEmpty() ? "YES" : "NO");
                bw.newLine();
            }
        }
        bw.close();
    }
}
