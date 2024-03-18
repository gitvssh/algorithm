package algorithm.module;

public class DnCPow {
    static long MOD = 1000000007;
    public long solve(int base, int exponent){
        if(exponent == 1){
            return base % MOD;
        }

        long temp = solve(base, exponent / 2);
        if(exponent % 2 == 1){
            return (temp * temp % MOD) * base % MOD;
        }
        return temp * temp % MOD;
    }
}
