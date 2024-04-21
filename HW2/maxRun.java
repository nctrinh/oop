import java.util.Scanner;

public class maxRun {

    public static int maxRunFunction(String inp){

        int cnt = 1;
        int maxCnt = 1;
        
        for(int i = 1; i < inp.length(); i++){

            if(inp.charAt(i) == inp.charAt(i - 1)){
                cnt++;
            }else{
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 1;
            }

        }

        return maxCnt;

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(maxRunFunction(inp));
        sc.close();

    }

}