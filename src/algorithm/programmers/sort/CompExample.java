package algorithm.programmers.sort;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompExample implements TestCase {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
//                .sorted(Comparator.naturalOrder().thenComparing(a -> a.substring(1, 2)))
                .sorted(Comparator.<String,String>comparing(a -> a.substring(1, 2)).thenComparing(Comparator.naturalOrder()))
                .toArray(String[]::new);
//        .thenComparing(a->a.substring(0,1))
    }
    @Override
    public void test() {
        String[] solution = solution(new String[]{"sun", "bed", "car"},1);
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }
}
