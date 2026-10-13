import java.util.Scanner;
public class PairStarsRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter any string: ");
        String str = sc.next();
        System.out.println();
        String newstr = pairStar(str);
        System.out.println("Old string was "+str);
        System.out.println("New string after inserting *s in adjacent identical characters is "+newstr);
    }
     
    public static String pairStar(String str){
    	// BASE CASE: 0 or 1 character -> there is no adjacent pair to separate
        if (str.length() <= 1)
            return str;
        // If the first two characters match, put a * between them, then
        // recurse on the string without its first character
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        else
            return str.charAt(0) + pairStar(str.substring(1));
	}

}
