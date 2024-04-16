package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12739
 * 돌림판
 */
public class Wheel implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        WheelBoard wheelBoard = new WheelBoard(br.readLine(), n);
        wheelBoard.changeColor(k);
        System.out.println(wheelBoard);
    }

    static class WheelBoard {

        int red;
        int blue;
        int green;
        String wheel;
        int length;

        public WheelBoard(String wheel, int length) {
            this.wheel = wheel;
            this.length = length;
            countColor();
        }

        private void countColor() {
            this.red = 0;
            this.blue = 0;
            this.green = 0;
            for (int i = 0; i < this.length; i++) {
                if (wheel.charAt(i) == 'R') {
                    red++;
                } else if (wheel.charAt(i) == 'B') {
                    blue++;
                } else {
                    green++;
                }
            }
        }

        @Override
        public String toString() {
            return red + " " + green + " " + blue;
        }

        public void changeColor() {
            StringBuilder sb = new StringBuilder(this.wheel);
            for (int i = 0; i < this.length; i++) {
                char pre = this.wheel.charAt((i - 1) >= 0 ? i - 1 : this.length - 1);
                char cur = this.wheel.charAt(i);
                char next = this.wheel.charAt((i + 1) < this.length ? i + 1 : 0);

                if (isAllSameOrAllDiff(pre, cur, next)) {
                    sb.setCharAt(i, 'B');
                } else {
                    ColorData colorData = new ColorData();
                    colorData.countColor(List.of(pre, cur, next));
                    if (isCase2(colorData)) {
                        sb.setCharAt(i, 'R');
                    } else {
                        sb.setCharAt(i, 'G');
                    }
                }
            }
            this.wheel = sb.toString();
            countColor();
        }

        public void changeColor(int i) {
            for (int j = 0; j < i; j++) {
                changeColor();
            }
        }

        private static boolean isAllSameOrAllDiff(char pre, char cur, char next) {
            return (pre == cur && cur == next) ||
                    (pre != cur && cur != next && pre != next);
        }
        private static boolean isCase2(ColorData colorData) {
            return (colorData.red == 2 && colorData.green == 1) || (colorData.green == 2 && colorData.blue == 1) || (colorData.blue == 2 &&
                    colorData.red == 1);
        }

        static class ColorData {
            int red;
            int green;
            int blue;

            public ColorData() {
                this.red = 0;
                this.green = 0;
                this.blue = 0;
            }

            public void countColor(List<Character> data) {
                data.forEach(c -> {
                    if (c == 'R') {
                        red++;
                    } else if (c == 'G') {
                        green++;
                    } else {
                        blue++;
                    }
                });
            }
        }
    }
}
