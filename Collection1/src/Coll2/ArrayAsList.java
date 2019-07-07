package Coll2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsList {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Ivan","Maria", "Stephan", "Amalia", "John");
        //List<String> strings = filtersList(list);
        System.out.println(filtersList(list));
    }
    public static List<String> filtersList (List<String> list){
        List<String> string = new ArrayList<>();
        for(int i = 1; i < list.size(); i++){
            if (list.get(i).length()!=4){
                string.add(list.get(i));
            }
        }
        return string;
    }
}
