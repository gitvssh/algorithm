package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.StringTokenizer;

public class Wheel implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        WheelBoard wheelBoard = new WheelBoard(br.readLine(), n);
        wheelBoard.changeColor(k);
        wheelBoard.printColor();
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

        public void printColor() {
            System.out.println(red + " " + green + " " + blue);
        }

        public void changeColor() {
            StringBuilder sb = new StringBuilder(this.wheel);
            for (int i = 0; i < this.length; i++) {
                int pre = (i - 1) >= 0 ? i - 1 : this.length - 1;
                int cur = i;
                int next = (i + 1) < this.length ? i + 1 : 0;

                if (isAllSameOrAllDiff(this.wheel, pre, cur, next)) {
                    sb.setCharAt(cur, 'B');
                } else {
                    ColorData colorData = new ColorData();
                    colorData.countColor(List.of(this.wheel.charAt(pre), this.wheel.charAt(cur), this.wheel.charAt(next)));
                    if (isCase2(colorData)) {
                        sb.setCharAt(cur, 'R');
                    } else {
                        sb.setCharAt(cur, 'G');
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

        private static boolean isAllSameOrAllDiff(String wheel, int pre, int cur, int next) {
            return (wheel.charAt(pre) == wheel.charAt(cur) && wheel.charAt(cur) == wheel.charAt(next) && wheel.charAt(pre) == wheel.charAt(
                    next)) || (wheel.charAt(pre) != wheel.charAt(cur)
                    && wheel.charAt(cur) != wheel.charAt(next) && wheel.charAt(pre) != wheel.charAt(next));
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
