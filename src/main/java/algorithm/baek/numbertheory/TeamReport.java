package algorithm.baek.numbertheory;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

public class TeamReport implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine());
        int n = Integer.parseInt("12");
        int result = 0;
        if(n%5 > 0 ){
            result = n/5 + 1;
        }else{
            result = n/5;
        }

        bw.write(result + "");
        bw.close();
    }
}
