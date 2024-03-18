package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class ConvertingArray implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int solution = solution(new int[]{1, 2, 3, 100, 99, 98});
        System.out.println(solution);
    }
    public int solution(int[] arr) {
        boolean flag = true;
        int repeat = 0;
        while(flag){
            int[] nextArr = convert(arr);
            boolean inFlag = true;
            for(int i=0;i<arr.length;i++){
                if(nextArr[i] != arr[i]){
                    inFlag = false;
                    break;
                }
            }
            if(inFlag){
                flag = false;
            }else{
                arr = nextArr;
                repeat++;
            }
        }
        return repeat;
    }

    public int[] convert(int[] arr){
        int[] retArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=50&&arr[i]%2==0){
                retArr[i] = arr[i]/2;
            }else if(arr[i]<50 && arr[i]%2!=0){
                retArr[i] = arr[i]*2+1;
            }
        }
        return retArr;
    }
}
