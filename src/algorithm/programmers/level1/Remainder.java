package algorithm.programmers.level1;

import algorithm.TestCase;
import algorithm.module.PrimeFactor;

public class Remainder implements TestCase {
    public int solution(int n) {
//        int target = n-1;
//        int p = 2;
//        int answer = -1;
//        while(target>=p*p){
//            if(target%p==0){
//                answer=p;
//                target/=p;
//            }else{
//                p++;
//            }
//        }
//        if(answer==-1) return target;
        for (int i = 2; i < n; i++) {
            if(n % i ==1) return i;
        }
        return -1;
    }
    @Override
    public void test() {
//        PrimeFactor pf = new PrimeFactor();
//        int[] ints = pf.primeFactors(10);
//        for (int anInt : ints) {
//            System.out.println("anInt = " + anInt);
//        }
        int solution = solution(10);
        System.out.println("solution = " + solution);
    }
}
