import java.util.Scanner;

public class Pastry {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int totalItems = 0;
        double totalAmount = 0;
        double totalDiscount = 0;
        String again = "y";

        while (again.equalsIgnoreCase("y")) {

            System.out.println("\n===== PASTRY MENU =====");
            System.out.println("1. Sarsado         - $50.00");
            System.out.println("2. Beef Broccoli   - $80.00");
            System.out.println("3. Ginataan        - $35.00");
            System.out.println("4. Caldereta       - $60.00");
            System.out.println("5. Bopis           - $30.00");

            System.out.print("\nEnter item number: ");
            int item = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            double price = 0;

            if (item == 1) {
                price = 50;
            } else if (item == 2) {
                price = 40;
            } else if (item == 3) {
                price = 35;
            } else if (item == 4) {
                price = 60;
            } else if (item == 5) {
                price = 30;
            }

            if (item < 1 || item > 5 || quantity < 1 || quantity > 10) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            String student = input.next();

            double subtotal = price * quantity;
            double discount = 0;

            if (student.equalsIgnoreCase("y")) {
                discount = subtotal * 0.10;
            }

            if (subtotal >= 500) {
                discount = discount + (subtotal * 0.05);
            }

            double orderTotal = subtotal - discount;

            System.out.println("\nSubtotal: $" + subtotal);
            System.out.println("Discount: $" + discount);
            System.out.println("Order total: $" + orderTotal);

            totalItems = totalItems + quantity;
            totalAmount = totalAmount + subtotal;
            totalDiscount = totalDiscount + discount;

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next();
        }

        double finalAmount = totalAmount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total before discount: $" + totalAmount);
        System.out.println("Total discount: $" + totalDiscount);
        System.out.println("Final amount: $" + finalAmount);
        System.out.println("Thank you for ordering!");

        input.close();
    }
}