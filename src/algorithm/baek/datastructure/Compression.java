package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.text.ParseException;


public class Compression implements TestCase {
    public String compress(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
                prev = chars[i];
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

    @Override
    public void test() throws ParseException {
        String compress = compress("33(562(71(9)))");
    }
}
