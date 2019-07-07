package Coll1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainColl1 {

    public static void main(String[] args) {

        Address a1 = new Address("LansbergAlee", 3);
        Address a2 = new Address("Boddin", 14);
        Address a3 = new Address("Parade", 1);
        Address a4 = new Address("Herman", 74);
        Address a5 = new Address("Karl-Marx", 11);

        Person p1 = new Person(a1, "Ivan Vasilievich");
        Person p2 = new Person(a2, "Petka Brovovich");
        Person p3 = new Person(a3, "Anka Pulimet");
        Person p4 = new Person(a4, "Spider Man");
        Person p5 = new Person(a5, "Batman");

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("********************************************************8");
        for (Address a: getAddresses(persons)){
            System.out.println(a);
        }
    }
    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> getAdd = new ArrayList<>();
        for (Person p: persons){
            getAdd.add(p.getAddress());

        }
        return getAdd;
    }
}
