import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeirdAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        generateWeirdAlgorithm(n);
    }

    public static void generateWeirdAlgorithm(long n) {
        while (n > 1) {
            System.out.print(n + " ");
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
        }
        System.out.print(1);
    }

}
