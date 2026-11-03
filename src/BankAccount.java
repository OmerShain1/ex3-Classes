public class BankAccount
{
    private int accountId;
    private String ownerName;
    private double balance;
    private boolean isActive;
    private static int nextId=1000;
    private static int totalAccounts = 0;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance=0;
        this.isActive = true;
        this.accountId = nextId;
        nextId++;
        totalAccounts++;
    }

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.isActive = true;
        this.accountId = nextId;
        nextId++;
        totalAccounts++;
        if(initialBalance>0)
        {
            this.balance=initialBalance;
        }
        else
        {
            this.balance = 0;
        }
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static boolean isValidAmount(double amount)
    {
        if(amount>0){
            return true;
        }
        return false;
    }

    public static int getNextAccountId() {
        return nextId;
    }

    public boolean deposit(double amount)
    {
        if(!isActive){
            return false;
        }
        if(!isValidAmount(amount))
        {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount)
    {
        if(!isActive)
        {
            return false;
        }
        if(!isValidAmount(amount))
        {
            return false;
        }
        if(amount>balance)
        {
            return false;
        }
        balance -= amount;
        return true;

    }

    public boolean transferTo(BankAccount destination, double amount)
    {
        if(destination==null||accountId==destination.getAccountId())
        {
            return false;
        }
        if(!this.isActive||!destination.isActive)
        {
            return false;
        }
        if(amount > this.balance||!isValidAmount(amount))
        {
            return false;
        }
        this.withdraw(amount);
        destination.deposit(amount);
        return true;

    }

    public int getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean closeAccount()
    {
        if(!this.isActive||balance!=0)
        {
            return false;
        }
        this.isActive = false;
        return true;
    }

    public String getAccountInfo()
    {
        String info = " Account Id: " + this.accountId + " Owner Name: " + this.ownerName + " Balance: " + this.balance + " Is active: " + this.isActive;
        return info;
    }

    public void setOwnerName(String ownerName)
    {
        if(!ownerName.equals(""))
        {
            this.ownerName = ownerName;
        }
    }
}
