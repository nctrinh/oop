package BANK_ACCOUNTs;

abstract public class superAccount {
    double balance;
    public int numOf_withdrawl;
    public int totalTransaction = 0;
    public void deposit(double amount){
        balance += amount;
        totalTransaction++;
    };
    abstract public void withdraw(double amount);
    public void endMonth(){
        totalTransaction = 0;
        System.out.print(balance);
    };
}
