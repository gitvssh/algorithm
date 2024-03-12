package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Warning implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime nowDateTime = LocalTime.parse(br.readLine(), dtf);
        LocalTime warningDateTime = LocalTime.parse(br.readLine(), dtf);
        LocalTime x = warningDateTime.minusHours(nowDateTime.getHour()).minusMinutes(nowDateTime.getMinute())
                .minusSeconds(nowDateTime.getSecond());

        bw.write(x.format(dtf));
        bw.close();
    }
}
