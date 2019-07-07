import java.util.List;

public class Person {
    String name;
    int age;
    Address address;
    List<BankAccount> bank;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, Address address, List<BankAccount> bank) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.bank = bank;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
