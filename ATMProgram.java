import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.println("Your account balance is: $" + account.getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance. Cannot withdraw.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("ATM Options:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
            }
        } while (choice != 0);

        System.out.println("Thank you for using the ATM.");
    }
}
