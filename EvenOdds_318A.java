import java.util.Scanner;

public class EvenOdds_318A {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();
        long k = sc.nextLong();

        // Check if k is coming in odds or even (Also add a check when n is odd as we will have more odds)
        if(k <= n/2 + n%2) {
            System.out.println(2*(k-1) + 1); // Print odd number from 1
        } else {
            System.out.println(2*(k - n/2 - n%2)); // print even number starting from half
        }
    }
}