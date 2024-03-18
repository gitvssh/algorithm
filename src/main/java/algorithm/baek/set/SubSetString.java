package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashSet;

public class SubSetString implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int len = str.length();
        HashSet<String> map = new HashSet<>();
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (!map.contains(str.substring(i, j)))
                    map.add(str.substring(i, j));
            }
        }
        bw.write(map.size() + "\n");
        bw.close();
    }
}
