public class Account {

  private String accountHolderName;
  private int accountNumber;
  private double balance;

  public Account(String accountHolderName, int accountNumber) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = 0.0;
  }

  public double deposit(double amount) {
    if (amount <= 0) {
      throw new InvalidAmountException("Deposit amount must be greater than 0.");
    }
    balance += amount;
    return balance;
  }

  public double withdrawal(double amount) {
    if (balance - amount < 0) {
      throw new InsufficientBalanceException("Withdrawal amount greater than available balance.");
    }
    if (amount <= 0) {
      throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
    }
    balance -= amount;
    return balance;
  }

  public double checkBalance() {
    return balance;
  }
}