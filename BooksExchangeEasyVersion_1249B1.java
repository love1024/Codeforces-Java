import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksExchangeEasyVersion_1249B1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Read number of queries
        int q = sc.nextInt();

        // While there are some queries left
        while(q-- > 0) {

            // Read number of kids and store them in an array
            int n = sc.nextInt();
            int[] kids = new int[n];
            for(int i = 0; i < n; i++) {
                kids[i] = sc.nextInt();
            }

            // Loop over all kids
            for(int i = 0; i < n; i++) {

                // Now try to move through the array by moving to the next
                // position which current element points to, keep doing this
                // process until reach the current elemen again
                int days = 1;
                int j = i;
                while(kids[j] != i+1) {
                    days++;
                    j = kids[j] - 1;
                }

                // Print number of days it took to reach the current element again
                System.out.print(days + (i == n -1 ? "" : " "));
            }
            System.out.println("");
        }
    }
}
