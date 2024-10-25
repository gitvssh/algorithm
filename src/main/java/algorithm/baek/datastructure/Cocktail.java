package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Cocktail implements TestCase {

    HashMap<String, Integer> ingredients = new HashMap<>();

    /*
    분석(5m)
    설계(5m)
    구현(20m)

    - 자료구조 해시를 사용해서 칵테일/재료를 저장
    - 황금비 값으로 칵테일을 만들 수 있는지 확인

    - 초기화 함수
    - 해시맵으로 칵테일 저장
    - 황금 칵테일 여부 확인
     */
    @Override
    public void test() throws ParseException, IOException {
        init(System.in);
        log.info(isGoldenRatio());
    }

    public void init(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            saveIngredients(br.readLine());
        }
    }

    private void saveIngredients(String input) {
        String[] split = input.split(" ");
        String name = split[0];
        int value = Integer.parseInt(split[1]);
        ingredients.put(name, ingredients.getOrDefault(name, 0) + value);
    }

    public String isGoldenRatio() {
        double goldenRatio = 1.618;

        return ingredients.keySet().stream()
                .flatMap(key -> ingredients.keySet().stream()
                        .filter(key2 -> !key.equals(key2))
                        .map(key2 -> {
                            int base = ingredients.get(key);
                            int compare = ingredients.get(key2);
                            double case1 = base * goldenRatio;
                            return (int) case1 == compare;
                        }))
                .anyMatch(result -> result) ? "Delicious!" : "Not Delicious...";
    }
}
