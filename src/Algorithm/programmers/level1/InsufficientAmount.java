package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class InsufficientAmount implements TestCase {
    public long solution(int price, int money, int count) {
//        long cache = money;
//        for (int i = 0; i < count; i++) {
//            cache -= price*(i+1);
//        }
//        if(cache>-1) return 0;
//        return Math.max(-(money*(price+(price*count))/2),0);
        return Math.max(price*(count* (count+1)/2) - money,0);
    }

    @Override
    public void test() {
        long solution = solution(3, 20, 4);
        System.out.println("solution = " + solution);
    }
}
