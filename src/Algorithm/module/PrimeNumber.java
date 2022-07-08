package Algorithm.module;

public class PrimeNumber {
    public boolean isPrimeNumber(int n){
        for (int i = 2; i*i <= n; i++) {
            if(n%i==0) return false;
        }
        System.out.println("n = " + n);
        return true;
    }
}
