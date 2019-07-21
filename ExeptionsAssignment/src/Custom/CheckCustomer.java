package Custom;

import Exeption.*;

import java.util.Arrays;
import java.util.List;

public class CheckCustomer {

    public static void main(String[] args) {

        BankAccount idenn1 = new BankAccount("DE2554");
        BankAccount idenn2 = new BankAccount("IT2544");
        BankAccount idenn3 = new BankAccount("RG25420");

        Customer customer1 = new Customer("Valia", 24, idenn1);
        Customer customer2 = new Customer("Igor", 15, idenn2);
        Customer customer3 = new Customer("Petro", 36, idenn3);

        List<Customer> customers = Arrays.asList(customer1, customer2, customer3);

        customerResult(customers);
    }

    public static int checkIbannLength (Customer customer) throws InvalidLength {
        if (customer.getAccount().getIbann().length() == 6)
            return customer.getAccount().getIbann().length();

        throw new InvalidLength("Invalid Length: ");
    }

    public static int checkAge(Customer customer) throws InvalidAge {
        if (customer.getAge() > 17)
            return customer.getAge();
        throw new InvalidAge("Invalid age: ");
    }

    public static String checkFirstIbann(Customer customer) throws Invalidibann {
        if (customer.getAccount().getIbann().substring(0, 2).equals("DE"))
            return customer.getAccount().getIbann().substring(0,2);
        throw new Invalidibann("Invalid ibann: ");
    }

    public static void customerResult(List<Customer> customers) {
        for (Customer c : customers) {

            System.out.println("customer "+c.getName()+":");
            try {
                checkAge(c);
                System.out.println("age is ok: "+c.getAge());
            } catch (InvalidAge ex) {
                System.out.println(ex.getMessage() + c.getAge());
            }

            try {
                checkFirstIbann(c);
                System.out.println("first latters is ok: "+c.getAccount().getIbann().substring(0,2));
            } catch (Invalidibann ex) {
                System.out.println(ex.getMessage()+c.getAccount().getIbann().substring(0,2));
            }

            try {
                checkIbannLength(c);
                System.out.println("ibann langth is ok: "+ c.getAccount().getIbann().length());
            } catch (InvalidLength invalidLength) {
                System.out.println(invalidLength.getMessage() + c.getAccount().getIbann().length());
            }
            System.out.println();
        }
    }

}
