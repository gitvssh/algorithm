package algorithm.baek.numbertheory;

import algorithm.TestCase;

public class FactorialCount implements TestCase {
    @Override
    public void test() {
        int n = 3;
        int two = 0;
        int five = 0;
        int count = 0;
        for (int i = n; i > 0; i--) {
            two += countFactor(i, 2);
            five += countFactor(i, 5);
        }
        System.out.println(Math.min(two, five));
    }

    public int countFactor(int n, int m){
        int count = 0;
        while(n>0){
            if(n%m==0) {
                count++;
                n /= m;
            }else{
                break;
            }
        }
        return count;
    }
}
