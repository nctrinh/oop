package BANK_ACCOUNTs;

public class NickleDime extends superAccount{

    @Override
    public void withdraw(double amount) {
        if(balance >= amount + 0.5){
            balance -= amount;
            totalTransaction++;
        }else{
            System.out.println("Insufficient minimum balance");
        }
    }
}
