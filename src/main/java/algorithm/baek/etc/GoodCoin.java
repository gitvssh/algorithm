package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

public class GoodCoin implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int tc = Integer.parseInt(br.readLine());
            while(tc-- > 0){
                solve(br,bw);
            }
        }
    }

    public static void solve(BufferedReader br, BufferedWriter bw) throws IOException{
        String str = br.readLine();
        bw.write("Denominations: " + str.substring(2).trim());
        bw.newLine();
        String[] arr = str.split(" ");
        boolean denominationQuality = true;
        for(int i=1;i<arr.length-1;i++){
            if(!(Integer.parseInt(arr[i]) * 2 <= Integer.parseInt(arr[i+1]))){
                denominationQuality = false;
                break;
            }
        }
        bw.write(denominationQuality?"Good coin denominations!":"Bad coin denominations!");
        bw.newLine();
        bw.newLine();
    }
}
