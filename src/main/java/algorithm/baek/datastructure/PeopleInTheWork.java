package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.HashMap;

/**
 * https://www.acmicpc.net/problem/7785 회사에 있는 사람
 */
public class PeopleInTheWork implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> log = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            String name = str[0];
            String state = str[1];
            if (log.get(name)==null) {
                log.put(name, state);
            }else {
                log.replace(name, state);
            }
        }
        for (String s : log.keySet()) {
            if (log.get(s).equals("enter")) {
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
    }
}
