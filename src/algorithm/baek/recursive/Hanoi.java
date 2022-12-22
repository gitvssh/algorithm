package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Hanoi implements TestCase {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void test() throws ParseException, IOException {
        int n = Integer.parseInt(br.readLine());
        bw.write((int) (Math.pow(2, n) - 1) +"\n");
        hanoi(n, 1, 2, 3);
        bw.close();
    }

    private void hanoi(int i, int start, int mid, int to) throws IOException {
        if (i == 1) {
            bw.write(start + " " + to+"\n");
            return;
        }
        hanoi(i - 1, start, to, mid);
        bw.write(start + " " + to+"\n");
        hanoi(i - 1, mid, start, to);
    }
}
