package algorithm;

import algorithm.baek.etc.Reverse;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

//        Reverse testCase = new Reverse();
//        doTest(testCase);

            int[] solution = solution(new int[]{1,4,2,5,3});
            System.out.println(solution);
    }

    public static int[] solution(int[] arr) {
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            if(idx==0){
                arr[idx++] = arr[i];
            }else if(arr[idx-1]<arr[i]){
                arr[idx++] = arr[i];
            }else if(arr[idx-1]>=arr[i]){
                idx--;
                i--;
            }
        }
        int[] stk = new int[idx];
        for(int i=0;i<idx;i++){
            stk[i] = arr[i];
        }
        return stk;
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
