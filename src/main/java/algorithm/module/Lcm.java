package algorithm.module;

public class Lcm {
    public int solve(int p, int q) {
        Gcd gcd = new Gcd();
        return p * q / gcd.solve(p,q);
    }
}
