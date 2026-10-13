import java.util.Scanner;
public class Count7Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter any number: ");
        int d = sc.nextInt();
        System.out.println();
        int num7s = count7(d);
        System.out.println("Number of 7's in the number "+d+" is "+num7s);
    }
    
    
    public static int count7(int n) {
    	// BASE CASE: no digits left to look at
        if (n == 0)
            return 0;
        // n % 10 is the rightmost digit, n / 10 drops it, so each call
        // shrinks the number by one digit
        if (n % 10 == 7)
            return 1 + count7(n / 10);
        else
            return count7(n / 10);
    }

}
