package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PrinterQueue implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        //테스트케이스
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //문서의 개수
            int m = Integer.parseInt(st.nextToken());
            //찾고자 하는 문서의 위치
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            //문서 저장
            for (int j = 0; j < m; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            //인쇄작업 시작
            int cnt = 0;
            while(deque.peekFirst()!=null){
                Integer now = deque.peekFirst();
                Iterator<Integer> iterator = deque.iterator();
                boolean flag = true;
                //우선순위 체크
                while(iterator.hasNext()){
                    Integer next = iterator.next();
                    if(now < next){
                        deque.addLast(deque.pollFirst());
                        flag = false;
                        break;
                    }
                }
                //인쇄
                if(flag) {
                    deque.pollFirst();
                    cnt++;
                    if (k == 0) {
                        bw.write(cnt + "\n");
                        break;
                    } else {
                        k--;
                    }
                }else{
                    if(k==0) k=deque.size()-1;
                    else k--;
                }
            }
        }
        bw.close();
    }
}
