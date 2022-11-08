package oder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderManagement {
    private static final String FILE_PATH = "order.csv";
    private  static OrderManagement orderManagement = new OrderManagement();
    public static OrderManagement getOderManagement() {
        return orderManagement;
    }

    private List<Order> orderList;

    private OrderManagement() {
        orderList = new ArrayList<>();
        readFromFile();
    }

    public void add(Order newOrder) {
        newOrder.setTotal();
        orderList.add(newOrder);
        saveFile();
    }

    public Order searchByOrderId(UUID orderId) {
        for (Order o : orderList) {
            if (o.getOrderId().equals(orderId)); {
                return o;
            }
        }
        return null;
    }

    public boolean removeByOderId(UUID orderId) {
        Order o = searchByOrderId(orderId);
        if (o != null) {
            orderList.remove(o);
            return true;
        }
        saveFile();
        return false;
    }

    public String printOrder() {

        String string = "";
        for (Order o : orderList) {
            string += o.toString();
        }
        readFromFile();
        return string;
    }

    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Order o : orderList) {
                bufferedWriter.write(o.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        orderList.clear();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Order order = handleLine(line);
                orderList.add(order);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Order handleLine(String line) {
        Order o;
        String[] strings = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate stringsDate = LocalDate.parse(strings[1], formatter);

        o = new Order(UUID.fromString(strings[0]), stringsDate, strings[2], strings[3],
                Double.parseDouble(strings[4]), Double.parseDouble(strings[5]), strings[6]);
        for (int i = 7; i < strings.length; i += 2) {
            o.addProduct(strings[i], Integer.parseInt(strings[i + 1]));
        }
        return o;
    }
}