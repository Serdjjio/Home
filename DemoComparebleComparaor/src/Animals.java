public class Animals implements Comparable<Animals> {
    private String name;
    private int weight;
    private String color;

    public Animals(String name, int weight, String color) {
        super();
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Animals [name=" + name + ", weight=" + weight + ", color=" + color + "]";
    }

    @Override
    public int compareTo(Animals o) {
        return this.weight - o.weight;
    }
}
