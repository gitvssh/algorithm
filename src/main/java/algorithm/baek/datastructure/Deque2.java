package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/28279
 * 덱2
 */
public class Deque2 implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        CustomDeque cd = new CustomDeque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("1") || command.equals("2")) {
                cd.command(command, st.nextToken());
            }else{
                bw.write(cd.command(command));
                bw.newLine();
            }
        }
        bw.close();
    }

    class CustomDeque{

        Deque<Integer> dq;

        CustomDeque() {
            dq = new ArrayDeque<>();
        }

        public String command(String command) {
            if(!command.equals("6") && dq.isEmpty()){
                return "-1";
            }

            switch(command){
                case "3":
                    return dq.pollFirst().toString();
                case "4":
                    return dq.pollLast().toString();
                case "5":
                    return dq.size() + "";
                case "6":
                    return dq.isEmpty()? "1" : "0";
                case "7":
                    return dq.peekFirst().toString();
                case "8":
                    return dq.peekLast().toString();
                default:
                    return "-1";
            }
        }

        public void command(String command, String s) {
            if(command.equals("1")) {
                dq.addFirst(Integer.parseInt(s));
            } else if(command.equals("2")) {
                dq.addLast(Integer.parseInt(s));
            }
        }
    }
}
