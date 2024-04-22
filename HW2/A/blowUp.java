import java.util.Scanner;

public class blowUp{

    public static String blowUpString(String inp){

        String ans = new String();
        int times = 1;
        int i = 0;

        while (i < inp.length()) {
            char tmp = inp.charAt(i);

            if( i != inp.length() - 1 && tmp <= '9' && tmp >= '0'){
                times = tmp - 48;
                for(int j = 0; j < times; j ++){
                    ans += inp.charAt(i + 1);
                }
                times = 1; 
                i++;
            }else{
                ans += tmp;
                i++;
            }            
        }           
        return ans;
        
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(blowUpString(inp));
        sc.close();

    }
}