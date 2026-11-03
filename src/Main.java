//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("Omer Shain", 10_000);
        BankAccount account2 = new BankAccount("Lebron James", 25_000);

        System.out.println("\naccount1 number: " + account1.getAccountId());
        System.out.println("\naccount2 number: " + account2.getAccountId());

        account1.deposit(500);
        account2.withdraw(200);
        account1.transferTo(account2, 300);

        System.out.println("\nAccount 2 balance: " + account2.getBalance());
        account2.withdraw(50000);
        System.out.println("\nAccount 2 balance: " + account2.getBalance());

        System.out.println("\n" + account1.getAccountInfo() + "\n" + account2.getAccountInfo());

        System.out.println("\n Number of accounts created: " + BankAccount.getTotalAccounts());

        System.out.println("\nNext account Id: " + BankAccount.getNextAccountId());
        BankAccount account3 = new BankAccount("Joe Biden", 1000);
        System.out.println("\naccount3 Id: " + account3.getAccountId());
        System.out.println("\nAccount 3 balance: " + account3.getBalance());

        account3.deposit(-500);
        account3.transferTo(account3, 100);

        System.out.println("\nAccount 3 balance: " + account3.getBalance());

        Bank bank = new Bank("Shain inc", 700);
        bank.setAccounts(account1, account2);
        System.out.println("\n"+ bank.getBankInfo());
    }
}