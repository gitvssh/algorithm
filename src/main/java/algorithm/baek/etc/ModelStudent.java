package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;

public class ModelStudent implements TestCase {

    private final int DAY_TIME = 24;
    private final int REST_TIME = 8;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int totalTime = 0;
        String[] time = br.readLine().split(" ");
        for (int i = 0; i < time.length; i++) {
            totalTime += Integer.parseInt(time[i]);
            totalTime += REST_TIME;
        }
        totalTime -= REST_TIME;

        int day = totalTime / DAY_TIME;
        int rest = totalTime % DAY_TIME;
        bw.write((day) + " " + rest);
        bw.close();
    }
}
