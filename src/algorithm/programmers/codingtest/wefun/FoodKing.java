package algorithm.programmers.codingtest.wefun;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 음식을 가장 다양하게 주문한 유저 찾기
 * 음식을 여러개 주문 가능, 같은 음식 여러번도 가능
 * 가장 많은 종류 음식 유저 아이디 배열, 같으면 오름차순 정렬
 * */
//@Slf4j
public class FoodKing implements TestCase {
    public String[] solution(String[] orders) {
        String[] answer = {};
        HashMap<String, User> users = new HashMap<>();
        HashMap<String, Integer> foodVariety = new HashMap<>();
        int orderList = orders.length;

        for (int i = 0; i < orderList; i++) {
            String[] item = orders[i].split(" ");
            User user;
            if (item.length == 0) break;
            if (!users.containsKey(item[0])) {
                user = new User(item[0]);
                users.put(item[0], user);
            } else {
                user = users.get(item[0]);
            }
//            //log.info("username : {}", item[0]);
//            //log.info("item length:{}", item.length);

            for (int j = 1; j < item.length; j++) {
                user.addOrder(item[j]);
//                //log.info("oder :{}", item[j]);
            }
            foodVariety.put(user.getUsername(), user.orderNum);
        }
//        for (Integer value : foodVariety.values()) {
//            //log.info("food :{}", value);
//        }

        Integer max = foodVariety.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        return foodVariety.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    private class User {
        private String username;
        private int orderNum;
        private Map<String, Integer> orders; //상품명, 주문횟수

        public User(String username) {
            this.username = username;
            this.orderNum = 0;
            this.orders = new HashMap<>();
        }

        public String getUsername() {
            return username;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void addOrder(String order) {
            if (orders.containsKey(order)) {
                orders.put(order, orders.get(order) + 1);
            } else {
                orders.put(order, 1);
                orderNum++;
            }
        }
    }

    @Override
    public void test() {
        solution(new String[]{"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"});

    }
}
