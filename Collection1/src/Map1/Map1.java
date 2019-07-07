package Map1;

import java.util.*;

public class Map1 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        String str = "";
        map.put("a", "Hi");
        map.put("b", "There");
        System.out.println(map.containsKey("a"));

        if (map.size()>1 || map.size()<2) {
            for (Map.Entry<String, String> m : map.entrySet()) {
                str = str + m.getKey();
                String value = map.get("a") + map.get("b");
           map.put(str,value);
            }
        }
        System.out.println(map);
    }
}
