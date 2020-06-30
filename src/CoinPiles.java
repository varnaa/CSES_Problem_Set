import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class CoinPiles {
  public static void main(String[] args) throws IOException {
    // Task:1754
    Scanner scanner1 = new Scanner(System.in);
    OutputStream outputStream = new BufferedOutputStream(System.out);
    int testCase = scanner1.nextInt();

    for (int i = 0; i < testCase; i++) {
      long a = scanner1.nextLong();
      long b = scanner1.nextLong();

      if ((a + b) % 3 == 0 && 2 * a >= b && 2 * b >= a) {
        outputStream.write("YES\n".getBytes());
      } else {
        outputStream.write("NO\n".getBytes());
      }
    }
  }
}
