package algorithm.baek.set;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashSet;

/**
 * https://www.acmicpc.net/problem/25192
 * 곰곰이
 */
public class GomGom implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (name.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }
            if (!set.contains(name)) {
                set.add(name);
                result++;
            }
        }
        System.out.println(result);
    }
}
