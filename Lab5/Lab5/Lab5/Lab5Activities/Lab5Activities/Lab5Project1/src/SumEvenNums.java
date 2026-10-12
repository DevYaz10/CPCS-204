
import java.util.Scanner;

public class SumEvenNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Upto which number you need the sum of even numbers? ");
        int n = sc.nextInt();
        System.out.println("");
        // Write the code here to check if 'n' is an odd number.
        // If 'n' is odd, make it even by subtracting 1 from it.

        System.out.println("The sum of even numbers from 1 to " + n + " is " + SumEven(n));
    }

    public static int SumEven(int n) {
        if (n % 2 != 0) {
            n--;
        }
        
        if (n == 0) {
            return 0;
        } else  {
            return n + SumEven(n - 2);
        }
    }

}
