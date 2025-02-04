package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) {
        //Map (key, value)
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("A", 2);
        map.put("A", 3);
        map.put("B", 1);
        map.put("B", 2);
        map.put("C", 5);
        map.put("D", 5);

        System.out.println(map.size());
        System.out.println(map.get("A"));   //Key로 value를
        System.out.println(map.containsKey("A")); //Key를 포함하는지

        //Keyset을 이용한 순회
        Set<String> keySet = map.keySet(); //순서 X
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            Integer v = map.get(k);
            System.out.println(k + " " + v);
        }
    }
}
