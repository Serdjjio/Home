import java.util.*;

public class Set1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Ivan");
        list.add("Maria");
        list.add("Piotr");
        list.add("Ivan");
        list.add("Anna");
        list.add("Maria");
        list.add("Ivan");

        System.out.println(removeDuplicates(list));
        System.out.println("******************************");

        System.out.println(getDuplicates(list));
    }

    public static List<String> removeDuplicates(List<String> input) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        set.addAll(input);
        list.addAll(set);
        return list;

    }

    public static List<String> getDuplicates(List<String> input) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 1 + i; j < input.size(); j++)
                if (input.get(i).equals(input.get(j))) {
                    list.add(input.get(i));
                }
        }
        set.addAll(list);
        list1.addAll(set);
        return list1;
    }
}
