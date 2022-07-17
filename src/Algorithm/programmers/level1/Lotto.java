package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Lotto implements TestCase {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zCnt = (int) Arrays.stream(lottos).filter(a -> a == 0).count();
        int missMatch = (int) Arrays.stream(lottos).
                filter(a -> Arrays.stream(win_nums)
                        .noneMatch(b -> b == a))
                .count();
        int high = (1 + missMatch - zCnt) > 0 ? (1 + missMatch - zCnt) : 1;
        int low = (1 + missMatch) < 7 ? (1 + missMatch) : 6;

        LongStream.of(
                        (lottos.length + 1) - (Arrays.stream(lottos).filter(
                                        a -> Arrays.stream(win_nums).anyMatch(w -> w == a || a == 0))
                                .count()),
                        (lottos.length + 1) - (Arrays.stream(lottos).filter(
                                        a -> Arrays.stream(win_nums).anyMatch(w -> w == a))
                                .count())
                ).mapToInt(op -> (int) (op > 6 ? 6 : op))
                .toArray();

        return new int[]{high > 6 ? 6 : high, low};
    }

    @Override
    public void test() {
        int[] solution = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int s : solution) {
            System.out.println("s = " + s);
        }
    }
}
