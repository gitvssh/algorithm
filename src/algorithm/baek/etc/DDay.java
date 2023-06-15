package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1308
 * D-Day
 * etc
 */
public class DDay implements TestCase {
    static int startYear, startMonth, startDay;
    static int endYear, endMonth, endDay;
    static int[] dayArray(int year) {
        int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            day[1] = 29;
        return day;
    }

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startYear = Integer.parseInt(st.nextToken());
        startMonth = Integer.parseInt(st.nextToken());
        startDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endYear = Integer.parseInt(st.nextToken());
        endMonth = Integer.parseInt(st.nextToken());
        endDay = Integer.parseInt(st.nextToken());

        if ((endYear - startYear > 1000) || (endYear - startYear == 1000 && endMonth > startMonth)
                || (endYear - startYear == 1000 && endMonth == startMonth && endDay >= startDay))
            System.out.println("gg");
        else {
            long T_findingdays = FindingDays(startYear, startMonth, startDay);
            long D_findingdays = FindingDays(endYear, endMonth, endDay);
            System.out.println("D-" + (D_findingdays - T_findingdays));
        }
    }

    static long FindingDays(int year, int month, int day) {
        long days = 0;
        int[] date;
        for (int i = 1; i < year; i++) {
            date = dayArray(i);
            for (int j = 0; j < 12; j++) {
                days += date[j];
            }
        }
        date = dayArray(year);
        for (int i = 0; i < month - 1; i++) {
            days += date[i];
        }
        days += day;
        return days;
    }
}
