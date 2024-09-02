import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleBanking {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Account account = new Account("SampleAccountHolderName", 123456);
    boolean isActiveSession = true;

    System.out.println("\nWelcome to Simple Banking!");

    while (isActiveSession) {
      System.out.println("Please select from the following options:\n");

      System.out.println("1. Check Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdrawal");
      System.out.println("4. Exit\n");

      String choice = scanner.nextLine();
      System.out.println();

      double currentBalance = account.checkBalance();
      double amount = 0;

      switch (choice) {
        case "1":
          System.out.println("Check Balance");
          System.out.println("-------------\n");
          currentBalance = account.checkBalance();
          System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          System.out.println("\n\tPress [Return] to return to the account menu: ");
          scanner.nextLine();
          break;
        case "2":
          System.out.println("Deposit");
          System.out.println("-------------\n");
          System.out.println("Enter amount to deposit: ");
          amount = scanner.nextDouble();
          try {
            currentBalance = account.deposit(amount);
            System.out.println("Successfully deposited $" + String.format("%.2f", amount) + " to your account.");
            System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          } catch (InvalidAmountException e) {
            System.out.println("Withdrawal unsuccessful.");
            System.out.println(e.getMessage());
          }
          System.out.println("\n\tPress [Return] to return to the account menu: ");
          scanner.nextLine();
          scanner.nextLine();
          break;
        case "3":
          System.out.println("Withdrawal");
          System.out.println("-------------\n");
          System.out.println("Enter amount to withdrawal: ");
          amount = scanner.nextDouble();
          try {
            currentBalance = account.withdrawal(amount);
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount) + " from your account.");
            System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          } catch (InsufficientBalanceException e) {
            System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
            System.out.println("Desired withdrawal amount: $" + String.format("%.2f", amount));
            System.out.println("Withdrawal unsuccessful.");
            System.out.println(e.getMessage());
          } catch(InvalidAmountException e) {
            System.out.println("Withdrawal unsuccessful.");
            System.out.println(e.getMessage());
          }
          System.out.println("\n\tPress [Return] to return to the account menu: ");
          scanner.nextLine();
          scanner.nextLine();
          break;
        case "4":
          System.out.println("Exiting...");
          isActiveSession = false;
          break;
        default:
          System.out.println("Please enter a valid selection.");
      }
      System.out.println("\n");
      
    }
    scanner.close();
  }
}