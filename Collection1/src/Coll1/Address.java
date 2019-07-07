package Coll1;

public class Address {


    String Street;
    int number;

    public Address(String street, int number) {
        Street = street;
        this.number = number;
    }

    public String getStreet() {
        return Street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return
                "Street='" + Street + '\'' +
                ", number=" + number +"}";
    }
}
