import java.util.Arrays;
import java.util.Comparator;

public class MainApp {

        public static void main(String[] args) {

            Animals cat = new Animals("Bars", 20, "red");
            Animals cat1 = new Animals("Murz", 25, "black");
            Animals cat2 = new Animals("Jorn", 13, "green");
            Animals cat3 = new Animals("Puh", 22, "Yellow");
            Animals cat4 = new Animals("Tom", 15, "blue");

            Pet p = new Pet("Bars", 20, "red",new Person("Olga"));
            Pet p1 = new Pet("Murz", 25,"black", new Person("Ola"));
            Pet p2 = new Pet("Jorn", 13,"green", new Person("OCda"));
            Pet p3 = new Pet("Puh", 22,"Yellow", new Person("Cvds"));
            Pet p4 = new Pet("Tom", 15,"blue", new Person("FDE"));

            Pet[] pets= {p,p1,p2,p3,p4};

            Animals [] animals = {cat, cat1, cat2, cat3,cat4, new Animals("rob", 6, "braun")};
            Comparator<Animals> comparator1 = new ComporatorByName();
            Comparator<Animals> comparator2 = new ComperatorByWeiaght();

            printArray(animals);
            Arrays.sort(animals);
            printArray(animals);

            Arrays.sort(animals, new ComperatorByWeiaght());
            printArray(animals);

            Arrays.sort(animals, new ComporatorByName());
            printArray(animals);

            Arrays.sort(animals, comparator1);
            printArray(animals);
            System.out.println("------------------------------------------");

            Arrays.sort(animals, new ComparatorByLast());
            printArray(animals);

            ComporatorByName c = new ComporatorByName();
            System.out.println(c.compare(cat1, cat2));
            System.out.println(c.toString());
        }

        public static void printArray(Animals [] animals) {
            for(Animals a:animals) {	//cycle есчё одни из методов выводу
                System.out.println(a);

                //for (int i = 0; i < animals.length; i++) {
                //	System.out.println(" - "+animals[i]);
                //}

            }
            System.out.println("---------------------------------------");

        }

    }
