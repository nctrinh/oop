import java.util.Scanner;

public class Ruler {
    public static void main(String[] args){
        String ruler = " 1 ";
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++){
            System.err.println(ruler);
            ruler = ruler + i + ruler;
        }
        scan.close();
    }
}
