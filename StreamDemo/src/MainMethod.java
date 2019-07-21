import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMethod {
    public static void main(String[] args) {

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

        System.out.println("1___******" + "\n" + addresses(persons) + "\n");
//address person

        System.out.println("2___******" + "\n" + withoutDuplicate(listName) + "\n");
// return Name without dublicate

        System.out.print("3___******" + "\n");
        mapLengthName(listName1).forEach((k, v) -> {
            System.out.println(k + "" + v);
        });
        System.out.println();
// return map k-nameLength< v-name

        System.out.print("4___******" + "\n");
        mapAgeName(persons).forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        System.out.println();
//return map k-age, v-name;

        System.out.println("5___******" + "\n" + bankStars(bank) + "\n");
// return stars bank

        System.out.print("6___******" + "\n");
        mapPersonBAccount(bank1).forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });
        System.out.println();
//return mapPersonAccount

        System.out.println("7___******" + "\n" + strLatter(str, "Indigo") + "\n");
//return String firstLatter

        System.out.println("8___******" + "\n" + auditNum(str1) + "\n");
//return booleanNumer

        System.out.println("9___******" + "\n" + strNum("23s3") + "\n");
//return booleanString

        System.out.println("10___******" + "\n" +personStars(person)+ "\n");
//return PersonStars

        System.out.println("11___******" + "\n" + joinPerson(persons) + "\n");
//join In Germany <name1> and <name2> and …<nameN> are of legal age
    }

    //1
    public static List<Address> addresses(List<Person> persons) {
        List<Address> addresses =
                persons
                        .stream()
                        .filter(p -> p.age > 17)
                        .map(Person::getAddress)  // .map(person -> person.getAddress())
                        .collect(Collectors.toList());
        return addresses;
    }

    //2
    public static Set<String> withoutDuplicate(Stream<String> listName) {
        Set<String> collectList = listName
                .collect(Collectors.toSet());
        return collectList;
    }

    //3
    public static Map<Integer, List<String>> mapLengthName(Stream<String> listName) {
        Map<Integer, List<String>> listMapa = listName
                .collect(Collectors.groupingBy(String::length));
        return listMapa;
    }

    //4
    public static Map<Integer, String> mapAgeName(List<Person> persons) {

        Map<Integer, String> listMap1 = persons
                .stream()
                .collect(Collectors.toMap(
                        Person::getAge, //p->p.getAge(),
                        Person::getName));
        return listMap1;
    }

    //5
    public static List<String> bankStars(Stream<BankAccount> bank) {

        List<String> listStars = bank.
                map(b -> alianate(b.getIban()))
                .collect(Collectors.toList());
        return listStars;
    }

    //6
    public static Map<Person, String> mapPersonBAccount(List<BankAccount> bank1) {
        Map<Person, String> bankMap = bank1
                .stream()
                .collect(Collectors.toMap(
                        BankAccount::getOwner,
                        BankAccount::getIban
                ));

        return bankMap;
    }

    //7
    public static String strLatter(List<String> str, String first) {
        char sumfirst = firstBeta(first);

        long list4 = str
                .stream()
                .filter((f) -> f.toLowerCase()
                        .charAt(0) == sumfirst)
                .count();
        List<String> list5 = str
                .stream()
                .filter((f) -> f.toLowerCase()
                        .charAt(0) == sumfirst)
                .map(s -> s)
                .collect(Collectors.toList());
        return list4 + "-" + list5;
    }

    //8
    public static List<String> auditNum(List<String> str) {
        List<String> list = str
                .stream()
                .map(f -> f = "" + auditNumer(f))
                .collect(Collectors.toList());
        return list;
    }

    //9
    public static Boolean strNum(String str) {
        String stri = str;
        return (stri.chars()
                .allMatch(Character::isDigit));
    }

    //10
    public static List<String> personStars(List<Person> person) {
        List<String> pstr = person.stream()
                .flatMap(p -> p.bank.stream())
                .map(m -> alianate(m.getIban()))
                //.map(m->m.getOwner())
                //.map(m1->alianate(m1.getName()))
                .collect(Collectors.toList());
        return pstr;
    }

    //11
    public static String joinPerson(List<Person> persons) {
        String str;
        return str = persons.
                stream()
                .filter(t -> t.getAge() > 17)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
    }

    public static String alianate(String input) {
        int fromIndex = 2;
        if (fromIndex >= input.length()) {
            return "false";
        }
        char[] chars = input.toCharArray();
        String tmp = String.copyValueOf(chars, 0, fromIndex);
        for (int i = fromIndex; i < chars.length; i++) {
            chars[i] = '*';
            tmp = tmp + chars[i];
        }
        return tmp;
    }

    public static char firstBeta(String input) {
        char[] chars = input.toLowerCase().toCharArray();

        return chars[0];
    }

    public static Boolean auditNumer(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            return Character.isDigit(chars[i]);
        }
        return true;
    }
}
