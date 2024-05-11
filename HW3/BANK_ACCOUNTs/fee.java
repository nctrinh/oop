package BANK_ACCOUNTs;

public class fee extends superAccount{

    @Override
    public void withdraw(double amount) {
        if(balance >= amount + 5){
            balance -= amount;
            numOf_withdrawl++;
        }else{
            System.out.println("Insufficient minimum balance");
        }
    }

    @Override
    public void endMonth(){
        balance -= 5;
        System.out.print(balance);
    }

}
