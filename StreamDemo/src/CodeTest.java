import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class CodeTest {
    Address a1 = new Address("Mira", 115);
    Address a2 = new Address("Pravdy", 25);
    Address a3 = new Address("Lenina", 13);
    Address a4 = new Address("Sadovay", 44);

    Person p1 = new Person("Ivan", 15, a1);
    Person p2 = new Person("Piotr", 18, a2);
    Person p3 = new Person("Maria", 26, a3);
    Person p4 = new Person("Elena", 10, a4);

    List<Person> persons = Arrays.asList(p1, p2, p3, p4);

    Stream<String> listName = Stream.of("Ivan",
            "Piotr",
            "Ivan",
            "Piotr",
            "Maria",
            "Ivan");
    Stream<String> listName1 = Stream.of("Ivan",
            "Piotr",
            "Elena",
            "Anna",
            "Maria",
            "Ian");

    BankAccount b1 = new BankAccount("DE123123", p1);
    BankAccount b2 = new BankAccount("NL675342", p2);
    BankAccount b3 = new BankAccount("FR879405", p3);
    BankAccount b4 = new BankAccount("DE096342", p4);

    Stream<BankAccount> bank = Stream.of(b1, b2, b3, b4);
    List<BankAccount> bank1 = Arrays.asList(b1, b2, b3, b4);

    List<String> str = Arrays.asList("Ivan",
            // Stream<String> str= Stream.of("Ivan",
            "Piotr",
            "Elena",
            "Anna",
            "Maria",
            "Ian");

    List<String> str1 = Arrays.asList("Ivan",
            // Stream<String> str= Stream.of("Ivan",
            "342",
            "Elena",
            "2535",
            "Ma3a",
            "Ianna");

    Person person1 = new Person("Piotr", 12, a1, Arrays.asList(b1, b2));
    Person person2 = new Person("Olig", 34, a2, Arrays.asList(b3, b4));

    List<Person> person = Arrays.asList(person1, person2);

    //1
    @Test
    public void testAddresses() {

        List<Address> input = MainMethod.addresses(persons);
        List<Address> expectation = Arrays.asList(a2, a3);
        assertEquals(expectation, input);
    }

    //2
    @Test
    public void withoutDuplicate() {
        Set<String> input = MainMethod.withoutDuplicate(listName);
        Set<String> result = new HashSet<>();
        result.add("Ivan");
        result.add("Piotr");
        result.add("Maria");
        assertEquals(result, input);
    }

    //3
    @Test
    public void testMapLengthName() {
        Map<Integer, List<String>> result = new HashMap<>();
        List<String> list1 = Arrays.asList("Ian");
        List<String> list2 = Arrays.asList("Ivan", "Anna");
        List<String> list3 = Arrays.asList("Piotr", "Elena", "Maria");
        result.put(3, list1);
        result.put(4, list2);
        result.put(5, list3);

        Map<Integer, List<String>> input = MainMethod.mapLengthName(listName1);
        assertEquals(result, input);
    }

    //4
    @Test
    public void testMapAgeName() {
        Map<Integer, String> input = MainMethod.mapAgeName(persons);
        Map<Integer, String> result = new HashMap<>();
        result.put(18, "Piotr");
        result.put(10, "Elena");
        result.put(26, "Maria");
        result.put(15, "Ivan");
        assertEquals(result, input);
    }

    //5
    @Test
    public void testBankStars() {
        List<String> actual = MainMethod.bankStars(bank);
        List<String> expected = Arrays.asList("DE******", "NL******", "FR******", "DE******");
        assertEquals(expected, actual);
    }

    //6
    @Test
    public void testMapPersonBankAccount() {
        Map<Person, String> acrual = MainMethod.mapPersonBAccount(bank1);
        Map<Person, String> expected = new HashMap<>();
        expected.put(p1, b1.iban);
        expected.put(p2, b2.iban);
        expected.put(p3, b3.iban);
        expected.put(p4, b4.iban);
        assertEquals(expected, acrual);
    }

    //7
    @Test
    public void testMapCountWord() {
        String actual = MainMethod.strLatter(str, "Indigo");
        String expected = "2-[Ivan, Ian]";
        assertEquals(expected, actual);
    }

    //8
    @Test
    public void testBoolenNumer() {
        List<String> actual = MainMethod.auditNum(str1);
        List<String> expected = Arrays.asList("false", "true", "false", "true", "false", "false");

    }

    //9
    @Test
    public void testBooleanStr(){
        Boolean actual = MainMethod.strNum("23s3");
        Boolean expected = false;
        assertEquals(expected,actual);
    }

    //10
    @Test
    public void testPersonStars(){
        List<String> actual = MainMethod.personStars(person);
        List<String> expected = Arrays.asList("DE******", "NL******", "FR******", "DE******");
        assertEquals(expected,actual);
    }

    //11
    @Test
    public void testJoinPersons() {
        assertEquals("In Germany Piotr and Maria are of legal age", MainMethod.joinPerson(persons));
    }
}
