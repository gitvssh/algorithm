package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class TaxiGeometry implements TestCase {
    public static final double PI = 3.14159265358979323846;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Double.parseDouble(br.readLine());

        System.out.println(R * R * Math.PI);
        System.out.println(2 * R * R);
    }
}
