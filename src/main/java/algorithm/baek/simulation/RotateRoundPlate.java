package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17822 백준 17822번 - 원판 돌리기
 */
public class RotateRoundPlate implements TestCase {

    /*
    분석(5m)
    설계(15m)
    구현(30m)

    1. 반지름이 1부터 N까지의 원판이 존재한다.
    2. 원판의 중심은 모두 같으며 반지름이 i이면 그 원판을 i번째 원판이라 한다.
    3. 원판은 M개의 정수로 이루어져 있으며 원판을 회전시킬 수 있다.
    4. 원판은 회전시킬 수 있으며 독립적으로 이루어진다.
    5. 원판을 회전시킬 때는 수의 위치를 기준으로 하며 회전시킨 후 수의 위치는 회전시키기 전과 일치해야 한다.
    6. 원판을 회전시킬 때 사용하는 변수는 x,d,k 이다.
    7. x의 배수인 원판을 d방향으로 k칸 회전시킨다. d가 0인 경ㅇ 시계방향, 1인 경우 반시계 방향이다.
    8. 인접하면서 수가 같은 것을 찾아서 제거한다.(모든 원판 대상)
    9. 인접하면서 수가 같은 것이 없는 경우, 평균보다 큰 수에서 1을 빼고 작은 수에는 1을 더한다
    10. T번 회전 시킨 후 원판에 적인 수의 합을 구한다.

    설계
    1. 원판은 개념일 뿐, 좌표계를 사용할 일이 없으니 그냥 ArrayList로 구현해도 됨
    2. 원판 조작 매커니즘만 구현
    o 원판은 ArrayList<ArrayList<Integer>>()를 가지고 있다.
    o 원판은 n번째 원판을 회전시킬 수 있다.
    - 원판은 회전시킨 원판의 수를 변경할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        RoundPlate roundPlate = new RoundPlate(n, m);
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = br.readLine();
        }
        roundPlate.initRoundPlate(numbers);
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            roundPlate.rotateNPlate(x, d, k);
            roundPlate.changeNumber();
        }
        System.out.println(roundPlate.getSum());
    }

    public static class RoundPlate {

        int[][] plate;

        public RoundPlate(int n, int m) {
            plate = new int[n][m];
        }

        public void initRoundPlate(String[] numbers) {
            for (int i = 0; i < plate.length; i++) {
                StringTokenizer st = new StringTokenizer(numbers[i]);
                for (int j = 0; j < plate[i].length; j++) {
                    plate[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        public int[][] getRoundPlate() {
            return plate;
        }

        /**
         * x의 배수인 원판을 회전할 수 있다.
         *
         * @param x         기준 배수
         * @param direction 방향(0: 시계방향, 1: 반시계방향)
         * @param k         회전 칸 수
         */
        public void rotateNPlate(int x, int direction, int k) {
            int n = plate.length;
            int m = plate[0].length;
            for (int plateIndex = 0; plateIndex < n; plateIndex++) {
                if ((plateIndex + 1) % x == 0) {
                    if (direction == 0) {
                        for (int j = 0; j < k; j++) {
                            int lastIndex = m - 1;
                            int temp = plate[plateIndex][lastIndex];
                            for (int i = lastIndex; i > 0; i--) {
                                plate[plateIndex][i] = plate[plateIndex][i - 1];
                            }
                            plate[plateIndex][0] = temp;
                        }
                    } else {
                        for (int j = 0; j < k; j++) {
                            int firstIndex = 0;
                            int temp = plate[plateIndex][firstIndex];
                            for (int i = firstIndex; i < m - 1; i++) {
                                plate[plateIndex][i] = plate[plateIndex][i + 1];
                            }
                            plate[plateIndex][m - 1] = temp;
                        }
                    }
                }
            }
        }

        public void changeNumber() {
            if (Arrays.stream(plate).flatMapToInt(Arrays::stream).noneMatch(i -> i != -1)) {
                return;
            }
            boolean isChanged = false;
            int nthPlate = plate.length;
            int plateSize = plate[0].length;
            for (int n = 0; n < nthPlate; n++) {
                for (int m = 0; m < plateSize; m++) {
                    if (plate[n][m] == -1) {
                        continue;
                    }
                    boolean bfs = bfs(n, m, plate[n][m], isChanged);
                    isChanged = isChanged ? true : bfs;
                }
            }
            if (!isChanged) {
                int sum = 0;
                int count = 0;
                for (int n = 0; n < nthPlate; n++) {
                    for (int m = 0; m < plateSize; m++) {
                        if (plate[n][m] != -1) {
                            sum += plate[n][m];
                            count++;
                        }
                    }
                }
                double avg = (double) sum / count;
                for (int n = 0; n < nthPlate; n++) {
                    for (int m = 0; m < plateSize; m++) {
                        if (plate[n][m] != -1) {
                            if (plate[n][m] > avg) {
                                plate[n][m] = plate[n][m] - 1;
                            } else if (plate[n][m] < avg) {
                                plate[n][m] = plate[n][m] + 1;
                            }
                        }
                    }
                }
            }
        }

        private boolean bfs(int n, int m, int target, boolean isChanged) {
            boolean isChangedLocal = isChanged;
            for (Direction dir : Direction.values()) {
                int[] correlation = dir.getCorrelation();
                int nextN = n + correlation[0];
                int length = plate[0].length;
                int nextM = (m + correlation[1] + length) % length;
                if (nextN < 0 || nextN >= plate.length) {
                    continue;
                }
                if (target == plate[nextN][nextM]) {
                    plate[n][m] = -1;
                    plate[nextN][nextM] = -1;
                    isChangedLocal = true;
                    bfs(nextN, nextM, target, isChanged);
                }
            }
            return isChangedLocal;
        }

        public int getSum() {
            int sum = 0;
            for (int n = 0; n < plate.length; n++) {
                for (int m = 0; m < plate[0].length; m++) {
                    if (plate[n][m] != -1) {
                        sum += plate[n][m];
                    }
                }
            }
            return sum;
        }
    }

    private enum Direction {
        UP(new int[]{1, 0}), DOWN(new int[]{-1, 0}), LEFT(new int[]{0, -1}), RIGHT(new int[]{0, 1});

        private final int[] correlation;

        Direction(int[] correlation) {
            this.correlation = correlation;
        }

        public int[] getCorrelation() {
            return correlation;
        }
    }
}
