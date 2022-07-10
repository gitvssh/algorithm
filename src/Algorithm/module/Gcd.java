package Algorithm.module;

public class Gcd {
    public int solve(int p, int q){
        if(q == 0) return p;
        return solve(q, p % q);
    }
}
