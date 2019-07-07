public class Pet extends Animals {
    Person owner;

    public Pet(String name, int weight, String color, Person owner) {
        super(name, weight, color);
        this.owner=owner;
        // TODO Auto-generated constructor stub
    }

    public Person getOwner() {
        return owner;
    }

}
