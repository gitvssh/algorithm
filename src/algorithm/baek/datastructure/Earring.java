package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Earring implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sce = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            } else {
                sce++;
            }

            ArrayList<String> girls = new ArrayList<String>();

            for (int i = 0; i < n; i++) {
                girls.add(br.readLine());
            }

            ArrayList<Integer> isNum = new ArrayList<Integer>();
            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (isNum.contains(num)) {
                    isNum.remove((Integer) num);
                } else {
                    isNum.add(num);
                }
            }

            int lost = isNum.get(0);
            System.out.println(sce + " " + girls.get(lost - 1));
        }

    }
}
