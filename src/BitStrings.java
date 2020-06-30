import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        // Task: 1617
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        findBitStrings(n);
        long two = 2;
        int mod = (int) 1e9 + 7;
        long output = 1;
        while (n > 0) {

            if ((n & 1) == 1) {
                output = (output * two) % mod;
            }

            n = n >> 1;
            two = (two * two) % mod;
        }

        System.out.println(output);
    }

    // solution with reduced lines of code.
    public static void findBitStrings(long n) {
        long output = 1;
        for (long i = 1; i <= n; i++) {
            output = 2 * output % ((int) 1e9 + 7);
        }

        System.out.println(output);
    }


}
