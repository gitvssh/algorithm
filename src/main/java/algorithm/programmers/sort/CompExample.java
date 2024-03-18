package algorithm.programmers.sort;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.Comparator;

public class CompExample implements TestCase {
    public String[] solution(String[] strings) {
        return Arrays.stream(strings)
                .sorted(Comparator.<String, String>comparing(a -> a.substring(1, 2)).thenComparing(Comparator.naturalOrder()))
                .toArray(String[]::new);
    }

    @Override
    public void test() {
        solution(new String[]{"sun", "bed", "car"});
    }
}
