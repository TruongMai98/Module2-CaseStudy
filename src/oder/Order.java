package oder;

import product.Product;

import java.util.*;

public class Order {
    private UUID oderId;
    private Date purchaseDate;
    private String customerId;
    private String customerName;
    private double subTotal;
    private double total;
    private int telephoneNumber;

    public Order(String customerId, String customerName, int telephoneNumber) {
        this.oderId = UUID.randomUUID();
        this.purchaseDate = new Date();
        this.customerId = customerId;
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
    }

    public List<HashMap<Product, Integer>> addProductList(String productId, int quantity) {
        List<String> productList = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < productList.size(); i++) {
            productList.add(String.valueOf(hashMap.put(productId,quantity)));

        }
        return productList;
    }

    public UUID getOderId() {
        return oderId;
    }

    public void setOderId(UUID oderId) {
        this.oderId = oderId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public double getSubTotal() {
        return productPrice() * ;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}