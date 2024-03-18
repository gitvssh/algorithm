package algorithm.baek.numbertheory;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Sweet implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer("15 16 17");
        Cake cakeA = new Cake(st);
        st = new StringTokenizer("19 32 90");
        Cake cakeC = new Cake(st);

        Cake cakeB = cakeA.newOperator(cakeC);
        bw.write(cakeB.toString());
        bw.close();
    }

    class Cake implements Comparable<Cake> {

        int x;
        int y;
        int z;

        Cake(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        Cake(StringTokenizer st) {
            this.x = Integer.parseInt(st.nextToken());
            this.y = Integer.parseInt(st.nextToken());
            this.z = Integer.parseInt(st.nextToken());
        }

        @Override
        public int compareTo(Cake o) {
            return (this.x - o.x) + (this.y - o.y) + (this.z - o.z);
        }

        public Cake newOperator(Cake c) {

            return new Cake(c.x - this.z, c.y/this.y, c.z-this.x);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + z;
        }
    }
}
