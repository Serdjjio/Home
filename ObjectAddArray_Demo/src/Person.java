public class Person {


    private String fName;
    private String lName;
    private int age;
    private int id;

    Person(String fName, String lName, int age, int id) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
