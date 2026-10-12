import java.util.Scanner;

public class SubNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Upto which number you need the subtraction of numbers? ");
        int n = sc.nextInt();
        System.out.println("");

        System.out.println("The subtraction of numbers from 1 to " + n + " is " + SubNumbers(n));
    }

    public static int SubNumbers(int a) {
        // // Base case 1: nothing left to subtract.
        // if (a <= 0) {
        //     return 0;
        // }
        // Base case 2: the first number (1) is the only one that stays positive.
        if (a == 1) {
            return 1;
        }
        // Every number after 1 is subtracted: 1 - 2 - 3 - ... - a
        return SubNumbers(a - 1) - a;
    }
}
