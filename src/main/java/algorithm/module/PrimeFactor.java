package algorithm.module;

import java.util.ArrayList;

public class PrimeFactor {
    public int[] primeFactors(int n) {
        if (n <= 0) return new int[]{};
        ArrayList<Integer> temp = new ArrayList<>();
        int p = 2;
        while (n > p * p) {
            if (n % p == 0) {
                temp.add(p);
                n /= p;
            } else {
                p++;
            }
        }
        temp.add(n);

        return temp.stream()
                .mapToInt(a -> a)
                .toArray();
    }
}
