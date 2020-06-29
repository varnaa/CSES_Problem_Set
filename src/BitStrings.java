import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        // Task: 1617
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
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
}
