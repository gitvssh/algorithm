package Algorithm.module;

public class ThreeFactorString {
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
}
