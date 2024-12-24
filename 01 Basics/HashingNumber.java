import java.util.Scanner;

public class HashingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // precompute
        int[] hash = new int[13];

        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        System.out.println("How many times number appear in array: ");
        int q = sc.nextInt();

        System.out.println("Numbers: ");
        while (q-- != 0) {
            int number;
            number = sc.nextInt();

            System.out.println(hash[number]);
        }
    }
}