package Custom;

public class BankAccount {

    private String ibann;

    public BankAccount(String ibann) {
        this.ibann = ibann;
    }

    public String getIbann() {
        return ibann;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ibann='" + ibann + '\'' +
                '}';
    }
}
