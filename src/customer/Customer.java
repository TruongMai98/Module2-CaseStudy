package customer;

public class Customer {
    private String customerId;
    private String customerName;
    private int telephoneNumber;

    public Customer() {
    }

    public Customer(String customerId, String customerName, int telephoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return customerId +
                "," +
                customerName +
                "," +
                telephoneNumber;
    }
}
