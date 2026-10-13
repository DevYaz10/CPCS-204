import java.util.Scanner;

public class CountArecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter any string: ");
        String str = sc.next();
        System.out.println();
        int numAs = countA(str);
        System.out.println("Number of A's in the string " + str + " is " + numAs);
    }

    public static int countA(String str) {
        if (str.length() == 0) {
            System.out.println("String is empty");
            System.out.println(str);
            return 0;

        }
        if (str.charAt(0) == 'A') {
            System.out.println(str);
            System.out.println("THERE IS AN A");
            return 1 + countA(str.substring(1));
        } else {
            System.out.println(str);
            System.out.println("THERE IS NO A");
            return countA(str.substring(1));
        }
    }

}
