import java.util.Comparator;

public class ComperatorByWeiaght implements Comparator<Animals> {
    @Override
    public int compare(Animals o1, Animals o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
