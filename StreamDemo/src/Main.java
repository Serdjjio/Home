import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Address a1 = new Address("Mira", 115);
        Address a2 = new Address("Pravdy", 25);
        Address a3 = new Address("Lenina", 13);
        Address a4 = new Address("Sadovay", 44);

        Person p1 = new Person("Ivan", 15, a1);
        Person p2 = new Person("Piotr", 18, a2);
        Person p3 = new Person("Maria", 26, a3);
        Person p4 = new Person("Elena", 10, a4);


        List<Person> persons = Arrays.asList(p1,p2,p3,p4);


        List<Address> addresses = persons
                .stream()
                .filter(p->p.age>17)
                .map(Person::getAddress)  // .map(person -> person.getAddress())
                .collect(Collectors.toList());
        System.out.println(addresses);
        System.out.println("1___*****************************");
//        //вернет список адресов тех людей, чей возраст больше 17 лет.
        System.out.println();

        Stream<String> listName = Stream.of("Ivan",
                "Piotr",
                "Ivan",
                "Piotr",
                "Maria",
                "Ivan");
        Set<String> collectList = listName
                .collect(Collectors.toSet());
        System.out.println(collectList);
        System.out.println("2_____*****************************");
//        //вернет список имен без  дупликатов
        System.out.println();

        Stream<String > listName1 = Stream.of("Ivan",
                "Piotr",
                "Elena",
                "Anna",
                "Maria",
                "Ian");
//        System.out.println(listName1.collect(Collectors.groupingBy(String::length)));

       Map<Integer, List<String>> listMapa = listName1
               .collect(Collectors.groupingBy(String::length));
        listMapa.forEach((k ,v)->{
            System.out.println(k+""+v);
        });
        System.out.println("3_____*****************************");
//      которая вернет мапу, где ключом является возраст, а значением список людей этого возраста
        System.out.println();

        Map<Integer, String> listMap1 = persons
                .stream()
                .collect(Collectors.toMap(
                        Person::getAge, //p->p.getAge(),
                        Person::getName));
        System.out.println(listMap1);
        System.out.println("4_____-----------------------------------------");
//      возвращает мапу, где ключом является возраст, а значением - список его имя
        System.out.println();

        BankAccount b1 = new BankAccount("DE123123", p1);
        BankAccount b2 = new BankAccount("NL675342", p2);
        BankAccount b3 = new BankAccount("FR879405", p3);
        BankAccount b4 = new BankAccount("DE096342", p4);

        Stream<BankAccount> bank = Stream.of(b1,b2,b3,b4);
        List<BankAccount> bank1 = Arrays.asList(b1,b2,b3,b4);

        List<String> listStars = bank.
                map(b -> alianate(b.getIban()))
                .collect(Collectors.toList());
        System.out.println(listStars);
        System.out.println("5_____-----------------------------------------");
//где в каждом IBANN символы после 3-го и до конца заменены звездочками.
        System.out.println();

       Map<Person, String> bankMap = bank1
               .stream()
               .collect(Collectors.toMap(
                       BankAccount::getOwner,
                       BankAccount::getIban
               ));
       bankMap.forEach((k,v)->{
           System.out.println(k+"->"+v);
        });
        System.out.println("6_____*****************************");
//      Мапа в которой ключ Person, value BankAkaunt
        System.out.println();

        List<String> str= Arrays.asList("Ivan",
       // Stream<String> str= Stream.of("Ivan",
                "Piotr",
                "Elena",
                "Anna",
                "Maria",
                "Ian");
        char sumfirst = firstBeta("Indigo");

       long list4 = str
               .stream()
               .filter((f)->f.toLowerCase()
                       .charAt(0)==sumfirst)
               .count();
       List<String> list5 = str
               .stream()
               .filter((f)->f.toLowerCase()
                       .charAt(0)==sumfirst)
               .map(s -> s)
               .collect(Collectors.toList());

        System.out.println(list4+"-"+list5);
        System.out.println("7_____*****************************");
//      возвращает количество слов, начинающихся на заданную букву
        System.out.println();

        List<String> str1= Arrays.asList("Ivan",
                // Stream<String> str= Stream.of("Ivan",
                "342",
                "Elena",
                "2535",
                "Ma3a",
                "Ianna");
       List<String> list6 = str1
               .stream()
               .map(f->f=""+auditNumer(f))
               .collect(Collectors.toList());
        System.out.println(list6);
        System.out.println("8_____*****************************");
//      возвращает количество слов, начинающихся на заданную букву
        System.out.println();

        String stri= "23s3";
        System.out.println(stri.chars()
                .allMatch(Character::isDigit));
        System.out.println("9_____*****************************");
//     является ли заданная строка целым числом
        System.out.println();

        Person person1 =new Person("Piotr", 12, a1, Arrays.asList(b1, b2));
        Person person2 =new Person("Olig", 34, a2, Arrays.asList(b3, b4));

        List<Person> person = Arrays.asList(person1, person2);
        List< String> pstr= person.stream()
                .flatMap(p->p.bank.stream())
                .map(m->alianate(m.getIban()))
                //.map(m->m.getOwner())
                //.map(m1->alianate(m1.getName()))
                .collect(Collectors.toList());

        System.out.println(pstr);
//возвращает список их банковских счетов с звездочками с третьего символа.
        System.out.println("10_____*****************************");
        System.out.println();

   int sum = persons
           .stream()
           .filter(p->p.age>17)
           .reduce(0,(a,b)->a+b.getAge(),(a,b) -> a+b);
        System.out.println("sum age = "+sum);
////возвращает список их банковских счетов с звездочками с третьего символа.
        System.out.println("11_____*****************************");
        System.out.println();

        String strlist = persons.
                stream()
                .filter(t->t.getAge()>17)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
        System.out.println(strlist);
//persons напечатает для тех, кто старше 17 лет: In Germany <name1>
// and <name2> and …<nameN> are of legal age.
        System.out.println("11_____*****************************");
        System.out.println();
   }

    public static String alianate(String input) {
        int fromIndex=2;
        if(fromIndex>=input.length()){
            return "false";
        }
        char [] chars = input.toCharArray();
        String tmp = String.copyValueOf(chars,0,fromIndex);
        for(int i=fromIndex; i<chars.length; i++){
            chars[i] ='*';
            tmp=tmp+chars[i];
       }
        return tmp;
    }

    public static char firstBeta(String input){
        char[] chars = input.toLowerCase().toCharArray();

        return chars[0];
    }

    public static Boolean auditNumer(String input){
        char [] chars = input.toCharArray();
        for(int i = 0; i<input.length(); i++){
            return Character.isDigit(chars[i]);
        }
        return true;
    }

}
