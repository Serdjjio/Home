import java.util.Comparator;

public class ComporatorByName implements Comparator<Animals> {
    @Override
    public int compare(Animals o1, Animals o2) {
        return o1.getName().compareTo(o2.getName());

    }

    @Override
    public String toString() {
        return "ComporatorByName ";
    }
}

