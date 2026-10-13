import java.util.Scanner;
public class ChangeXYRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter any string in lower case: ");
        String str = sc.next();
        System.out.println();
        String newstr = changeXY(str);
        System.out.println("Old string was "+str);
        System.out.println("New string after changing x's into y's is "+newstr);
    }
    
    public static String changeXY(String str) {
    	// BASE CASE: empty string -> nothing left to change
        if (str.length() == 0)
            return "";
        char first = str.charAt(0);
        if (first == 'x')
            first = 'y';
        // Keep this (possibly changed) character in front of the answer for
        // the rest of the string
        return first + changeXY(str.substring(1));
    }

}
