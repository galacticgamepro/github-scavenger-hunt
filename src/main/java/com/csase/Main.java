import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CafeteriaOrder> orderList = new ArrayList<>();

        // 3 placeholder objects for testing
        orderList.add(new CafeteriaOrder(1111, "Pizza", 5.50));
        orderList.add(new CafeteriaOrder(2222, "Burger", 6.00));
        orderList.add(new CafeteriaOrder(3333, "Salad", 4.50));

        System.out.println("=== Welcome to the Cafeteria Pre-Order System ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Place a New Order (Student)");
            System.out.println("2. View Active Orders (Staff)");
            System.out.println("3. Exit Program");
            System.out.print("Select an option: ");

            String choiceInput = scanner.nextLine();

            switch (choiceInput) {
                case "1":
                //loop
                    int id = -1;
                    while (id == -1) {
                        System.out.print("Enter your 4-digit Student ID: ");
                        String idInput = scanner.nextLine();
                        try {
                            id = Integer.parseInt(idInput);
                            if (id < 1000 || id > 9999) {
                                System.out.println("Invalid ID. Please enter a valid 4-digit ID.");
                                id = -1; // Reset to loop again
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid selection, try again (Numbers only).");
                        }
                    }

                    String item = "";
                    double price = 0.0;
                    boolean validItem = false;

                    while (!validItem) {
                        System.out.println("\n--- TODAY'S MENU ---");
                        System.out.println("1. Pizza  ($5.50)");
                        System.out.println("2. Burger ($6.00)");
                        System.out.println("3. Salad  ($4.50)");
                        System.out.print("Select a meal option (1-3): ");
                        String itemChoice = scanner.nextLine();

                        switch (itemChoice) {
                            case "1":
                                item = "Pizza";
                                price = 5.50;
                                validItem = true;
                                break;
                            case "2":
                                item = "Burger";
                                price = 6.00;
                                validItem = true;
                                break;
                            case "3":
                                item = "Salad";
                                price = 4.50;
                                validItem = true;
                                break;
                            default:
                                System.out.println("Invalid selection, try again.");
                        }
                    }

                    // Instantiate the custom OOP object and add it to the list
                    CafeteriaOrder newOrder = new CafeteriaOrder(id, item, price);
                    orderList.add(newOrder);
                    System.out.println("Success! Your order for a " + item + " has been placed.");
                    break;

                case "2":
                    //Active Orders View 
                    System.out.println("\n--- Active Orders ---");
                    if (orderList.isEmpty()) {
                        System.out.println("No active orders placed.");
                    } else {
                        for (int i = 0; i < orderList.size(); i++) {
                            CafeteriaOrder order = orderList.get(i);
                            System.out.printf("%d. ID: %d | Item: %-6s | Total: $%.2f\n",
                                    (i + 1), order.getStudentID(), order.getSelectedItem(), order.getTotalPrice());
                        }
                    }
                    break;

                case "3":
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
