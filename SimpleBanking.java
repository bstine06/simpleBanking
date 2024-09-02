import java.util.Scanner;

public class SimpleBanking {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Account account = new Account("SampleAccountHolderName", 123456);

    System.out.println("\nWelcome to Simple Banking!");

    while (true) {
      System.out.println("Please select from the following options:\n");

      System.out.println("1. Check Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdrawal");
      System.out.println("4. Exit\n");

      int choice = scanner.nextInt();
      scanner.nextLine();
      System.out.println("\n");

      double currentBalance = account.checkBalance();
      double amount = 0;

      switch (choice) {
        case 1:
          System.out.println("Check Balance");
          currentBalance = account.checkBalance();
          System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          break;
        case 2:
          System.out.println("Deposit");
          amount = scanner.nextDouble();
          currentBalance = account.deposit(amount);
          System.out.println("Successfully deposited $" + String.format("%.2f", amount) + " to your account.");
          System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          break;
        case 3:
          System.out.println("Withdrawal");
          amount = scanner.nextDouble();
          currentBalance = account.withdrawal(amount);
          System.out.println("Successfully withdrew $" + String.format("%.2f", amount) + " from your account.");
          System.out.println("Current balance: $" + String.format("%.2f", currentBalance));
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Please enter a valid selection.");
      }
    }

  }
}