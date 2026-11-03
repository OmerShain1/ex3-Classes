public class Bank
{
    private String bankName;
    private int bankCode;
    private BankAccount account1;
    private BankAccount account2;

    public Bank(String bankName, int bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public void setAccounts(BankAccount a, BankAccount b)
    {
        this.account1 = a;
        this.account2 = b;
    }

    public double getTotalBalance()
    {
        return account1.getBalance()+account2.getBalance();
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankInfo()
    {
        return "Bank name: " + bankName + " Bank Code: " + bankCode + account1.getAccountInfo() + account2.getAccountInfo() ;
    }


}
