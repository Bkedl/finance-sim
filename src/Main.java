import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();

        System.out.println("Welcome to the Portfolio Simulator!");
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Transaction (Buy/Sell)");
            System.out.println("2. View Transactions");
            System.out.println("3. Show Portfolio Value");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Validation
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number from 1 to 4.");
                scanner.nextLine(); // discard invalid input
                continue; // go back to menu
            }

            switch (choice) {
                case 1:
                    // Add a transaction
                    System.out.print("Enter Instrument Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Instrument Symbol (e.g., AAPL, TSLA): ");
                    String symbol = scanner.nextLine().toUpperCase();

                    // Get current price from MockInstrument class
                    double price = MockInstrument.getPrice(symbol);
                    if (price == 0) {
                        System.out.println("Symbol not found in mock data. Try again.");
                        break;
                    }

                    Instrument instrument = new Instrument(name, symbol, price);

                    // Quantity Validation
                    int quantity;
                    System.out.print("Enter Quantity: ");
                    if (scanner.hasNextInt()) {
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                        if (quantity <= 0) {
                            System.out.println("Quantity must be a positive number.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid quantity! Please enter a number.");
                        scanner.nextLine();
                        break;
                    }

                    // Transaction validation
                    System.out.print("Enter Transaction Type (Buy/Sell): ");
                    String type = scanner.nextLine().trim();
                    if (!type.equalsIgnoreCase("Buy") && !type.equalsIgnoreCase("Sell")) {
                        System.out.println("Invalid transaction type! Please enter Buy or Sell.");
                        break;
                    }

                    Transaction transaction = new Transaction(instrument, quantity, LocalDate.now(), type);
                    portfolio.addTransaction(transaction);

                    System.out.println("Transaction added successfully!");
                    break;

                case 2:
                    // View transactions
                    portfolio.viewTransactions();
                    break;

                case 3:
                    // Show portfolio value
                    System.out.println("Calculating portfolio value...");
                    double totalValue = portfolio.getPortfolioValue();
                    System.out.println("Total Portfolio Value: $" + totalValue);
                    break;

                case 4:
                    // Exit
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 4.");
            }
        }

        scanner.close();
    }
}