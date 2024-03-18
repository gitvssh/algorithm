package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class HamberMaker implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
        }
        String s = sb.toString();
        int res = 0;
        int i = Integer.MAX_VALUE;
        while (i >= 0) {
            i = sb.indexOf("1231");
            if (i > 0) sb.delete(i, i + 4);
            res++;
        }

    }
}
