package oder;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class OrderManagementMenu {
    OrderManagement orderManagement = OrderManagement.getOderManagement();
    public void displayMenu() {
        System.out.println("_________________________________");
        System.out.println("|               MENU            |");
        System.out.println("---------------------------------");
        System.out.println("|          Quả lý hóa đơn       |");
        System.out.println("|1. Thêm hóa đơn                |");
        System.out.println("|2. Xóa hóa đơn                 |");
        System.out.println("|3. Tìm theo ID hóa đơn         |");
        System.out.println("|4. In hóa đơn                  |");
        System.out.println("|0. Thoát                       |");
        System.out.println("---------------------------------");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            displayMenu();
            System.out.println("Nhập số");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1 -> add();
                case 2 -> remove();
                case 3 -> searchByOrderId();
                case 4 -> printOrder();
                default -> {
                }
            }
        }
    }

    private void add() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng");
        String customerId = scanner.nextLine();
        System.out.println("Tên khách hàng");
        String customerName = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng");
        String telephoneNumber = scanner.nextLine();
        Order newOrder = new Order(customerId, customerName, telephoneNumber);
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("0. Dừng thêm sản phẩm");
            int choose = scanner.nextInt();
            scanner.nextLine();
            if (choose == 1) {
                System.out.println("Nhập id sản phẩm");
                String productId = scanner.nextLine();
                System.out.println("Nhập số lượng mua");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                newOrder.addProduct(productId, quantity);
            } else {
                break;
            }
        } while (true);

        orderManagement.add(newOrder);
    }

    private void remove() {
    }

    private void searchByOrderId() {

    }

    private void printOrder() {
        System.out.println(orderManagement.printOrder());
    }
}
