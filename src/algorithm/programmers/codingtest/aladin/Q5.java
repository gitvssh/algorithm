package algorithm.programmers.codingtest.aladin;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q5 implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        int[] nums = {1, 4, 2, 6, 5, 3,2,1,3,2,1,2};
        List<List<Integer>> subsequences = findCookieList(nums);
        int[] kthValue = getKthSubsequenceAsArray(3, subsequences);
        System.out.println(kthValue);
    }

    public int[] getKthSubsequenceAsArray(int k, List<List<Integer>> subsequences) {
        if (k < 0 || k >= subsequences.size()) {
            throw new IllegalArgumentException("Invalid index: " + k);
        }

        return convertListToArray(subsequences.get(k));
    }

    private int[] convertListToArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

    public List<List<Integer>> findCookieList(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findIncreasingSubsequences(nums, 0, new ArrayList<>(), result);
        return sortSubsequences(result);
    }

    private List<List<Integer>> sortSubsequences(List<List<Integer>> subsequences) {
        return subsequences.stream()
                .sorted(Comparator.comparing((List<Integer> list) -> list.get(0))
                        .thenComparingInt(List::size))
                .collect(Collectors.toList());
    }

    private void findIncreasingSubsequences(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() > 2) {
            result.add(new ArrayList<>(current));
        }

        IntStream.range(index, nums.length)
                .filter(i -> current.isEmpty() || current.get(current.size() - 1) < nums[i])
                .forEach(i -> {
                    current.add(nums[i]);
                    findIncreasingSubsequences(nums, i + 1, current, result);
                    current.remove(current.size() - 1);
                });
    }
}