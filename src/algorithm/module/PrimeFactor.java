package algorithm.module;

import java.util.ArrayList;

public class PrimeFactor {
    public int[] primeFactors(int n){
        /*
        1. input N >0 ?
        2. p=2;
        3. while N>p^2, != -> return add N
        4. N mod p == 0 -> add p, N=N/p
        5.         != p=p+1
        */
        if(n<=0) return new int[]{};
        ArrayList<Integer> temp = new ArrayList<>();
        int p = 2;
        while(n>p*p){
            if(n%p==0){
                temp.add(p);
                n/=p;
            }else{
                p++;
            }
        }
        temp.add(n);

        return temp.stream()
                .mapToInt(a->a)
                .toArray();
    }
}
