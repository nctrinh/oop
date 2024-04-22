import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Appearances {

    public static <T> int sameCount  (Collection<T> a, Collection<T> b){
        int cnt = 0;
        
        Collection<T> commonElement = new HashSet<T>(a);

        commonElement.retainAll(b);

        for(T i : commonElement){
            if(Collections.frequency(a, i) == Collections.frequency(b, i)){
                cnt++;
            }
        }
        return cnt;
    }
    
    
    public static void main(String[] args) {
        Collection<Character> c1 = new ArrayList<Character>();
        Collection<Character> c2 = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = 0; i < a; i++){
            Character inp = sc.next().charAt(0);
            c1.add(inp);           
        }
        int b = sc.nextInt();
        for(int i = 0; i < b; i++){
            Character inp = sc.next().charAt(0);
            c2.add(inp);           
        }
        
        System.out.println(Appearances.sameCount(c1, c2));

        sc.close();
    }
}
