package Coll5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainColl5 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        list1.add("dd");

        List<String> list2 = new ArrayList<>();
        list2.add("cc");
        list2.add("dd");
        list2.add("aa");
        list2.add("bb");

        list1.addAll(list2);

        System.out.println(list1);

        List<Integer> list3In = Arrays.asList(1, 23, 4, 5, 64, 45, 26, 12, 15);
        System.out.println(listNoLast(list3In, 25));
    }

    public static List<Integer> listNoLast(List<Integer> list, int max) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if(list.get(i)<max){
                returnList.add(list.get(i));
            }
        }
            return returnList;
    }

}
