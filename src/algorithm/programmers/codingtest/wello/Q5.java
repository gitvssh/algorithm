package algorithm.programmers.codingtest.wello;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Q5 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String p = "PM 11:59:59";
        TimeUtil time = new TimeUtil(p);
        time.addSeconds(1);
        System.out.println(time);
    }

    class TimeUtil{
        private int hour;
        private int minute;
        private int second;

        public TimeUtil(String p) {
            this.hour = Integer.parseInt(p.substring(3, 5));
            this.minute = Integer.parseInt(p.substring(6, 8));
            this.second = Integer.parseInt(p.substring(9, 11));
            if (p.substring(0, 2).equals("PM")) {
                if (hour != 12) {
                    hour += 12;
                }
            } else if (p.substring(0, 2).equals("AM") && hour == 12) {
                hour = 0;
            }
        }

        public void addSeconds(int n) {
            int addHour = n / 3600;
            int addMinute = (n % 3600) / 60;
            int addSecond = (n % 3600) % 60;

            second += addSecond;
            if(second >= 60) {
                minute += 1;
                second -= 60;
            }

            minute += addMinute;
            if(minute >= 60) {
                hour += 1;
                minute -= 60;
            }

            hour += addHour;
            if(hour >= 24) {
                hour -= 24;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(hour < 10 ? "0" + hour : hour).append(":")
                    .append(minute < 10 ? "0" + minute : minute).append(":")
                    .append(second < 10 ? "0" + second : second);
            return sb.toString();
        }
    }
}