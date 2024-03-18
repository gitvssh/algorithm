package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BasketBall implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        String name;
        for (int i = 0; i < n; i++) {
             name = br.readLine().substring(0, 1);
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }else{
                map.put(name, 1);
            }
        }
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        StringBuilder sb = new StringBuilder();
        String res = "PREDAJA";
        while (it.hasNext()) {
            name = it.next();
            if(map.get(name)>=5){
                sb.append(name);
            }
        }
        if(sb.length()==0) {
            System.out.println(res);
        }else{
            System.out.println(sb.toString());
        }
    }
}
