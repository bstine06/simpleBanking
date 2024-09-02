import java.util.Scanner;

public class SimpleBanking {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Simple Banking!");
    System.out.println("Please select from the following options:");

    System.out.println("1. Create Account");
    System.out.println("2. Check Balance");

    int choice = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Your choice was:");
    System.out.println(choice);
  }
}