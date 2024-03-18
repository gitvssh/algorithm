package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10811
 * 바구니 뒤집기
 * 배열 뒤집는 인덱스 찾는게 암산으로만 하기 조금 까다로웠음, 메모 작성하면서 해야함
 */
public class ReverseBasket implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] tmp;
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==y) continue;
            tmp = new int[y+1-x];
            //역순으로 tmp 저장
            for(int j=y;j>=x;j--){
                tmp[y-j]=arr[j];
            }
            for(int j=0;j<=y-x;j++){
                arr[x+j] = tmp[j];
            }
        }
        for(int i=1;i<=n;i++){
            bw.write(arr[i]+" ");
        }
        bw.newLine();
        bw.close();
    }
}
