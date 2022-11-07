package algorithm.module;

public class Eratosthenes {
    public int[] solve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        int[] primes = new int[count];
        for (int i = 2, j = 0; i <= n; i++) {
            if (isPrime[i]) primes[j++] = i;
        }
        return primes;
    }

    public int[] solve2(int n) {
        int[] arr = new int[n];
        arr[1] = 1;
        if (n < 2) return arr;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                for (int j = 2; i * j < n; j++) {
                    arr[i * j] = 1;
                }
            }
        }
        return arr;
    }
}
