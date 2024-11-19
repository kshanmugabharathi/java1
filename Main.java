import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager(10);  // Capacity for 10 customers

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customers");
            System.out.println("3. Find Customer by Name");
            System.out.println("4. Add Rewards Points to Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    boolean isRegular = true; // Assume all new customers are regular for reward points system
                    Customer customer = new Customer(name, email, phone, isRegular);
                    customerManager.addCustomer(customer);
                    break;
                case 2:
                    customerManager.displayCustomers();
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String searchName = scanner.nextLine();
                    Customer foundCustomer = customerManager.findCustomerByName(searchName);
                    if (foundCustomer != null) {
                        System.out.println("Customer found: " + foundCustomer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    String rewardName = scanner.nextLine();
                    System.out.print("Enter points to add: ");
                    int points = scanner.nextInt();
                    customerManager.addRewardsPointsToCustomer(rewardName, points);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
