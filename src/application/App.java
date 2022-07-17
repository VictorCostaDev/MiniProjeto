package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = scan.nextLine();
        System.out.print("Email: ");
        String clientEmail = scan.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        scan.nextLine();
        Date clientBirthdate = sdf.parse(scan.nextLine());

        Client client = new Client(clientName, clientEmail, clientBirthdate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String orderStatus = scan.nextLine();
        System.out.print("How many items to this order? ");
        int numberOfOrders = scan.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

        for(int i = 1; i <= numberOfOrders; i++) {
            System.out.printf("Enter #%d item data:\n", i);
            System.out.print("Product name: ");
            scan.nextLine();
            String productName = scan.nextLine();
            System.out.print("Product price: ");
            Double productPrice = scan.nextDouble();
            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantityProducts = scan.nextInt();

            OrderItem orderItem = new OrderItem(quantityProducts, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order.toString());
        scan.close();

    }
}
