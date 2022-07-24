package algorithm.module;

import algorithm.TestCase;

public class ThreeFactorString implements TestCase {
    private String getString(int i, int j, int k) {
        int a = 0;
        int b = 0;
        int c = 0;
        if (i > j) {//i>j
            if (i > k) {//i>j?k
                a = i;
                b = Math.max(j, k);
                c = Math.min(j, k);
            } else {//i?k>j
                a = Math.max(i, k);
                b = Math.min(i, k);
                c = j;
            }
        } else {//j>i
            if (i > k) {
                a = j;
                b = Math.max(i, k);
                c = Math.min(i, k);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        return sb.toString();
    }

    @Override
    public void test() {
        getString(1, 2, 3);
    }
}
