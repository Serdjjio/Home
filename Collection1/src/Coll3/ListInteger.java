package Coll3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInteger {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(5,2,3,8,5);

        System.out.println(getboolean(list1,list2));

    }

    public static List<String> getboolean (List<Integer> list1,List<Integer> list2 ){
        List<String> list3 = new ArrayList<>();
        for (int i =0; i<list1.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                list3.add("Yes");
            } else list3.add("No");
        }
        return list3;
    }
}
