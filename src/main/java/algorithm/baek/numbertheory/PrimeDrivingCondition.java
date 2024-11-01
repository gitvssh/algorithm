package algorithm.baek.numbertheory;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Arrays;

public class PrimeDrivingCondition implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = null;
            while ((input = br.readLine()) != null) {
                if (input.equals("END 0000")) {
                    break;
                }
                Plate plate = new Plate(input);
                bw.write(plate.getPlate());
                bw.newLine();
            }
        }
    }
}

class Plate {

    private String plate;
    private int number;

    Plate(String str) {
        String[] strs = str.split(" ");
        this.plate = strs[0];
        this.number = Integer.parseInt(strs[1]);
    }

    public String getPlate() {
        if (PrimeUtil.isPrime(number)) {
            return plate + " " + String.format("%04d", number);
        }

        for (int i = number + 1; i <= 9999; i++) {
            if (PrimeUtil.isPrime(i)) {
                return plate + " " + String.format("%04d", i);
            }
        }

        return getNextPlate() + " 0002";
    }

    private String getNextPlate() {
        char[] chars = plate.toCharArray();
        int n = chars.length;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == 'Z') {
                chars[i] = 'A';
            } else {
                chars[i]++;
                return new String(chars);
            }
        }
        return "A" + new String(chars);
    }
}

class PrimeUtil {
    private static boolean[] isPrime;

    static {
        erathosthene();
    }

    public static boolean isPrime(int n) {
        return isPrime[n];
    }

    private static void erathosthene() {
        isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}