public class MainApp {

    public static void main(String[] args) {
        Person p1 = new Person("Vasia","Nikifor", 20,22345);
        Person p2 = new Person("Petia","Mlickyi", 26,22352);
        Person p3 = new Person("Olia","Abramovich", 22,22564);
        Person p4 = new Person("Ralf","Frion", 19,22765);
        Person p5 = new Person("Agata","Agutin", 18,22856);
        Person p6 = new Person("Fima","Aizen", 35,22456);
        Person p7 = new Person("Alf","Neon", 34,22233);
        Person p8 = new Person("Real","Anionm", 32,221243);
        Person p9 = new Person("Ali","Abdula", 40,22006);

        Person [] per = {p1, p2, p3, p4, p5};

        ArrayAdd arr = new ArrayAdd();

        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        arr.add(p5);
        arr.add(p6);
        arr.add(p7);
        arr.add(p8);
        arr.add(p9);

     //   arr.addAll(per);
      //  arr.print();

        System.out.println("************************");

        arr.addAll(3,per);
        arr.print();

        System.out.println("**************");

        arr.removeRange(3,6);
        arr.print();
    }
}
