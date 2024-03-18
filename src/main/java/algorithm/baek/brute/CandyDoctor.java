package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2508
 * 사탕 박사 고창영
 */
public class CandyDoctor implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] box = new char[n][m];
            for(int j=0;j<n;j++){
                box[j] = br.readLine().toCharArray();
            }
            int result = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(box[j][k] == 'o'){
                        if(j-1>=0 && box[j-1][k] == 'v'&&j+1<n && box[j+1][k] == '^') result++;
                        else if(k-1>=0 && box[j][k-1] == '>'&&k+1<m && box[j][k+1] == '<') result++;
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.close();
    }
}
