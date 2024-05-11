package BANK_ACCOUNTs;

import java.util.Random;

public class Gambler extends superAccount{

    @Override
    public void withdraw(double amount) {
        Random random = new Random();
        int x = random.nextInt(100);
        if(x >= 49){
            if(balance >= amount * amount){
                balance -= amount * amount;
                numOf_withdrawl++;
                totalTransaction++;
            }else{
                System.out.println("Insufficient minimum balance");
            }
        }
    }

}
