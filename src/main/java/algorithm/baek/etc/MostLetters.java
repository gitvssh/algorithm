package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class MostLetters implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] arr = new int[26];
        int max = 0;
        str = br.readLine();
        while(str != null){
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c >= 'a' && c <= 'z'){
                    arr[c-'a']++;
                    max = Math.max(max, arr[c-'a']);
                }
            }
            str = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(arr[i] == max){
                sb.append((char)(i+'a'));
            }
        }
        System.out.println(sb.toString());

    }
}
