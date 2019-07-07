import java.util.Comparator;

public class ComparatorByLast implements Comparator<Animals> {


    @Override
    public int compare(Animals o1, Animals o2) {
        String s1=o1.getName();
        String s2=o2.getName();
        if (s1!=null && s1.length()>0 && s2!=null && s2.length()>0){
            char c1 = s1.charAt(s1.length()-1);
            char c2 = s2.charAt(s1.length()-1);
            if(c1>c2) return 1;
            if(c1<c2) return -1;
            return 0;
        }
        return 0;
    }
}
