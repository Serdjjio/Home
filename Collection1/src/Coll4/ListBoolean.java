package Coll4;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

public class ListBoolean {

    public static void main(String[] args) {


        List<Integer> listIn = new ArrayList<>();
        listIn.add(1);
        listIn.add(2);
        listIn.add(3);
        listIn.add(4);
        listIn.add(5);
        System.out.println("REVERS:" + "\n" + listIn);
        Collections.reverse(listIn);
        System.out.println(listIn);

        System.out.println("***********************************************");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        list1.add("dd");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("cc");
        list2.add("dd");
        list2.add("aa");
        list2.add("bb");


        cyclic(list1, list2);
        System.out.println(cyclic(list1, list2));
    }


    public static boolean cyclic(LinkedList<String> list1, LinkedList<String> list2) {
        int size = list1.size();
        if (list1.equals(list2)) {
            return true;
        }
        for (int i = 0; i < size - 1; i++) {
            list1.addFirst(list1.get(size - 1));
            list1.removeLast();

            if (list1.equals(list2)) {
                return true;
            }
        }
        return false;
    }
}
