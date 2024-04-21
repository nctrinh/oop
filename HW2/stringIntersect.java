import java.util.Scanner;

public class stringIntersect {

    public static boolean StringIntersect(String a, String b, int len){
        return b.length() == len;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(StringIntersect(a, b, a.length()));
        sc.close();
        
    }
}
