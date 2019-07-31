package jTest;
import Custom.*;
import Exeption.InvalidAge;
import Exeption.InvalidLength;
import Exeption.Invalidibann;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Jtest {

    @Test (expected = InvalidAge.class)
    public void testAgeEx() throws InvalidAge{
        BankAccount idenn1 = new BankAccount("DE2554");
        Customer customer1 = new Customer("Valia", 15, idenn1);
        CheckCustomer.checkAge(customer1);
    }

    @Test
    public void testAge() throws InvalidAge {
        BankAccount idenn1 = new BankAccount("DE2554");
        Customer customer1 = new Customer("Valia", 24, idenn1);

        int result = CheckCustomer.checkAge(customer1);
        assertEquals(result>17,true);
    }

    @Test (expected = Invalidibann.class)
    public void testFirstIbanEx() throws Exception {
        BankAccount idenn1 = new BankAccount("DT2554");
        Customer customer1 = new Customer("Valia", 15, idenn1);
        CheckCustomer.checkFirstIbann(customer1);
    }
    @Test
    public void testFirstIban()throws Exception{
        BankAccount idenn1 = new BankAccount("DE2554");
        Customer customer1 = new Customer("Valia", 15, idenn1);

        assertEquals("DE",CheckCustomer.checkFirstIbann(customer1));
    }

    @Test (expected = InvalidLength.class)
    public void testIbanLengthEx()throws Exception{
        BankAccount idenn1 = new BankAccount("DE25354");
        Customer customer1 = new Customer("Valia", 15, idenn1);

        CheckCustomer.checkIbannLength(customer1);
    }
    @Test
    public void testIbanLength () throws Exception{
        BankAccount idenn1 = new BankAccount("DE2554");
        Customer customer1 = new Customer("Valia", 15, idenn1);

        assertEquals(6,CheckCustomer.checkIbannLength(customer1));
    }
}
