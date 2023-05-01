package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Colatz implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] res = solution(10);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public int[] solution(int start) {
        int mid = 0;
        ArrayList<Integer> list = new ArrayList();
        list.add(start);
        while(true){
            if(mid==0) mid = start;
            if(mid%2==0){
                mid /= 2;
            }else{
                mid = mid * 3 + 1;
            }
            list.add(mid);
            if(1==mid) break;
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
