import java.io.*;
import java.util.Scanner;

public class CustomerManager {
    private Customer[] customers;
    private int customerCount;
    private static final String FILE_NAME = "customers.txt";

    public CustomerManager(int capacity) {
        customers = new Customer[capacity];
        customerCount = 0;
        loadCustomersFromFile();
    }

    public void addCustomer(Customer customer) {
        Customer existingCustomer = findCustomerByName(customer.getName());
        if (existingCustomer != null) {
            existingCustomer.addRewardsPoints(5); // Add 5 points if customer already exists
            System.out.println("Customer already exists. Added 5 reward points. Total points: " + existingCustomer.getRewardsPoints());
        } else {
            if (customerCount < customers.length) {
                customers[customerCount++] = customer;
                System.out.println("Added new customer successfully!");
            } else {
                System.out.println("Customer array is full!");
            }
        }
        saveCustomersToFile();
    }

    public void displayCustomers() {
        for (int i = 0; i < customerCount; i++) {
            System.out.println(customers[i]);
        }
    }

    public Customer findCustomerByName(String name) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                return customers[i];
            }
        }
        return null;
    }

    public void addRewardsPointsToCustomer(String name, int points) {
        Customer customer = findCustomerByName(name);
        if (customer != null && customer.isRegular()) {
            customer.addRewardsPoints(points);
            System.out.println("Congratulations, " + name + "! You have earned " + points + " points. Total points: " + customer.getRewardsPoints());
            saveCustomersToFile();
        } else {
            System.out.println("Customer not found or not a regular customer.");
        }
    }

    private void loadCustomersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    String email = parts[1];
                    String phone = parts[2];
                    boolean isRegular = Boolean.parseBoolean(parts[3]);
                    int rewardsPoints = Integer.parseInt(parts[4]);
                    customers[customerCount++] = new Customer(name, email, phone, isRegular, rewardsPoints);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load customer data.");
        }
    }

    private void saveCustomersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < customerCount; i++) {
                Customer customer = customers[i];
                writer.println(customer.getName() + "," +
                        customer.getEmail() + "," +
                        customer.getPhone() + "," +
                        customer.isRegular() + "," +
                        customer.getRewardsPoints());
            }
        } catch (IOException e) {
            System.out.println("Could not save customer data.");
        }
    }
}
