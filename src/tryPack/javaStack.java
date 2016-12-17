package tryPack;
import java.util.*;

public class javaStack{
    public static void main(String[] args) {
        int[] a = new int[5];
        int IN = 0;
        for(int i = 0;i < a.length;i++){
            inside:
            while(true){
                System.out.println("Enter a number:");
                try {
                    Scanner scan = new Scanner(System.in);
                    int input = scan.nextInt();
                    IN = input;
                    break inside;
                }
                catch (Exception err) {
                    System.out.println("THAT'S NOT A NUMBER");
                    continue;
                }
            }
            a[a.length - i - 1] = IN;
        }
        for(int i = 0;i < a.length;i ++){
            System.out.println(a[i]);
        }
    }
    
}