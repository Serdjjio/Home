package Coll1;

public class Person {

    Address address;
    String fName_lName;

    public Person(Address address, String fName_lName) {
        this.address = address;
        this.fName_lName = fName_lName;
    }

    public Address getAddress() {
        return address;
    }

    public String getfName_lName() {
        return fName_lName;
    }

    @Override
    public String toString() {
        return
                "address - {" + address +
                ", Person - {" + fName_lName + " " +
                "}"+"\n";
    }
}