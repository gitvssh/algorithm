package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pokemon implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            map.put(str,String.valueOf(i));
            map.put(String.valueOf(i),str);
        }
        for(int i=0;i<m;i++){
            bw.write(map.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
    }
}
