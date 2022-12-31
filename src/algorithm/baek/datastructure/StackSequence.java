package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class StackSequence implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if(idx < m) {
                for (int j = idx + 1; j <= m; j++) {
                    stack.addFirst(j);
                    sb.append("+\n");
//                    bw.write("+");
//                    bw.newLine();
                    idx = j;
                }
                stack.pollFirst();
                sb.append("-\n");
//                bw.write("-");
//                bw.newLine();
            }else{
                if(stack.peekFirst() == m){
                    stack.pollFirst();
                    sb.append("-\n");
//                bw.write("-");
//                bw.newLine();
                }else{
                    System.out.println("NO");
                    flag=false;
                    break;
                }
            }
        }
        if(flag) System.out.println(sb);;
    }
}
