package Algorithm.leetCode.search.array;

import Algorithm.TestCase;

import java.util.*;

public class SumClosest implements TestCase {
    /*
     * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     *
     * 1. 세 수의 합 컬렉션 생성,
     * 2. target만큼 빼고 차이 값 구한 뒤 정렬
     * 3. 차이가 가장 작은 값의 합 반환<K,V>

     * 투팩터 -> 정렬해놓고 따로 가공하지 않고 검색색
    * */
    public int threeSumClosest(int[] nums, int target) {
        long beforeTime = System.currentTimeMillis();
        //절대값 예외케이스 체크용
        HashMap<Integer, Integer> map = new HashMap<>();
        //캐시
        HashSet<String> visited = new HashSet<>();
        ArrayList<Integer> sum = new ArrayList<>();
        //1. 세 수의 합 컬렉션 생성,
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    String s = getString(i, j, k);
                    if (visited.contains(s)) continue;
                    if((nums[i] + nums[j] + nums[k])==target) return nums[i] + nums[j] + nums[k];
                    sum.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("1번 이후 : "+secDiffTime);
//        for (Integer integer : sum) {
//            System.out.println("integer = " + integer);
//        }
        sum.stream().forEach(a -> map.put(Math.abs(a - target), a));
        Object[] objects = sum.stream().map(a -> Math.abs(a - target)).distinct().sorted(Comparator.naturalOrder()).toArray();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("2번 이후 : "+secDiffTime);
//        for (Object object : objects) {
//            System.out.println("object = " + object);
//        }

        //2. target만큼 빼고 차이 값 구한 뒤 정렬

        return map.get(objects[0]);
    }

    private String getString(int i, int j, int k) {
        int a = 0, b = 0, c = 0;
        if (i > j) {//i>j
            if (i > k) {//i>j?k
                a = i;
                b = (j > k) ? j : k;
                c = (j > k) ? k : j;
            } else {//i?k>j
                a = (i > k) ? i : k;
                b = (i > k) ? k : i;
                c = j;
            }
        } else {//j>i
            if (i > k) {
                a = j;
                b = (i > k) ? i : k;
                c = (i > k) ? k : i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        String s = sb.toString();
        return s;
    }

    public int backup(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> sum = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(nums[0]);
        queue.add(nums[1]);
        int temp = nums[0] + nums[1];

        //1. 세 수의 합 컬렉션(sum)
        for (int i = 1; i < nums.length - 1; i++) {
            queue.add(nums[i + 1]);
            temp += nums[i + 1];
            sum.add(temp);
            temp -= queue.poll();
        }
        for (Integer integer : sum) {
            System.out.println("before sort = " + integer);
        }
        //2. target만큼 빼고 차이 값 구한 뒤 정렬
        sum.stream().forEach(a -> map.put(Math.abs(a - target), a));
        Object[] mapKey = map.keySet().toArray();
        Arrays.sort(mapKey);
        System.out.println("mapKey = " + mapKey[0]);
        Integer integer1 = map.get(mapKey[0]);
        System.out.println("integer1 = " + integer1);
        for (Integer integer : sum) {
            System.out.println("after sort = " + (integer - target));
        }
        for (Integer integer : map.keySet()) {
            System.out.println("integer = " + integer);
        }
//        Integer integer = map.get();
//        System.out.println("integer = " + integer);
        //3. 가장 작은 값 반환
        return 0;
    }

    @Override
    public void test() {
//        int i = threeSumClosest(new int[]{-1, 2, 1, -4,-3,-6,1,2,5,3,3}, 1);
//        int i = threeSumClosest(new int[]{1, 1, 1, 1}, 4);
//        int i = threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2);
        int[] array = new int[]{-43,57,-71,47,3,30,-85,6,60,-59,0,-46,-40,-73,53,68,-82,-54,88,73,20,-89,-22,39,55,-26,95,-87,-57,-86,28,-37,43,-27,-24,-88,-35,82,-3,39,-85,-46,37,45,-24,35,-49,-27,-96,89,87,-62,85,-44,64,78,14,59,-55,-10,0,98,50,-75,11,97,-72,85,-68,-76,44,-12,76,76,8,-75,-64,-57,29,-24,27,-3,-45,-87,48,10,-13,17,94,-85,11,-42,-98,89,97,-66,66,88,-89,90,-68,-62,-21,2,37,-15,-13,-24,-23,3,-58,-9,-71,0,37,-28,22,52,-34,24,-8,-20,29,-98,55,4,36,-3,-9,98,-26,17,82,23,56,54,53,51,-50,0,-15,-50,84,-90,90,72,-46,-96,-56,-76,-32,-8,-69,-32,-41,-56,69,-40,-25,-44,49,-62,36,-55,41,36,-60,90,37,13,87,66,-40,40,-35,-11,31,-45,-62,92,96,8,-4,-50,87,-17,-64,95,-89,68,-51,-40,-85,15,50,-15,0,-67,-55,45,11,-80,-45,-10,-8,90,-23,-41,80,19,29,7};
        int i = threeSumClosest(array, 255);
        System.out.println("i = " + i);
    }
}
