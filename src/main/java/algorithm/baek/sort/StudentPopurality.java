package algorithm.baek.sort;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25325
 * 학생 인기도
 */
public class StudentPopurality implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> popularity = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            popularity.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String student = st.nextToken();
                popularity.put(student, popularity.get(student) + 1);
            }
        }

        // Create a list of Map.Entry objects for sorting
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(popularity.entrySet());

        // Sort the entries in descending order of value (popularity)
        Collections.sort(entries, (entry1, entry2) -> {
            if(entry2.getValue() == entry1.getValue()){
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return entry2.getValue() - entry1.getValue();
        });

        // Print the values in sorted order
        for (Map.Entry<String, Integer> entry : entries) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.close();
    }
}
