package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.ParseException;
import java.util.StringTokenizer;

public class KoreanAge implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int birthYear = Integer.parseInt(st.nextToken());
        int birthMonth = Integer.parseInt(st.nextToken());
        int birthDay = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int currentYear = Integer.parseInt(st.nextToken());
        int currentMonth = Integer.parseInt(st.nextToken());
        int currentDay = Integer.parseInt(st.nextToken());

        int age = currentYear - birthYear;
        int koreanAge = currentYear - birthYear + 1;
        int yearAge = currentYear - birthYear;

        if(currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)){
            age--;
        }

        bw.write(age + "\n" + koreanAge + "\n" + yearAge);
        bw.close();
    }
}
