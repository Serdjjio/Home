public class RecursingApp {
    static int I0=0;
    static int I1=1;
    public static void main(String[] args) {
        int [] data ={1, 2, 3, 4, 5};
        String str = "dron";

        System.out.println(sumInitRec(data));
        System.out.println(sumInitFactorial(data));
        System.out.println(strInitRevers(str));
    }
    public static int sumInitRec(final int []a){
        return sumRec(a,0);
    }
    private static int sumRec (final int [] a, int i){
        if(i>=a.length-1){
            return a[a.length-1];
        }
        return a[i]+sumRec(a, i+1);
    }
    public static int sumInitFactorial(final int []a){
        return sumRec(a,1);
    }

    private static int sumFactorial (final int [] a, int i){
        if(i>=a.length-1){
            return a[a.length-1];
        }
        return a[i]*sumRec(a, i+1);
    }

    public static String strInitRevers(String str){
        return strRevers(str, str.length()-1);
    }

    public static String strRevers(String str, int i){
        String tmp;
        if(i<=0){
            return tmp=""+str.charAt(str.length()-1);
        }
        return tmp=""+strRevers(str, i-1)+str.charAt(str.length()-i-1);
    }
}
