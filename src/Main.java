import customer.CustomerManagementMenu;
import oder.OrderManagementMenu;
import product.ProductManagementMenu;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
//        new ProductManagementMenu().menu();
//        new CustomerManagementMenu().menu();
        new OrderManagementMenu().menu();
    }
}