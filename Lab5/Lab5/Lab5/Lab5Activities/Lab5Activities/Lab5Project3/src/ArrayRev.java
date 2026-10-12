import java.util.Scanner;
public class ArrayRev {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements of the array ? ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("");
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < a.length; i++){
            System.out.println("Enter the element "+(i+1)+": ");
            a[i] = sc.nextInt();
        }
        System.out.println("Array elements before swapping are ");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]+" ");
        }
        
        ArrayRevRec(a, 0, a.length-1);
        System.out.println("Array elements after swapping are ");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]+" ");
        }
        
    }
    
    public static void ArrayRevRec(int[] a, int i, int j){
        
        
        
        
    }
    
}
