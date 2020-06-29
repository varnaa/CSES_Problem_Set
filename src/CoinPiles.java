import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TLE for using std output and takes more than 1s to execute.
// Solution is correct.


public class CoinPiles {
  public static void main(String[] args) {
    // Task:1754
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    List<String> output = new ArrayList<>();

    for (int i = 0; i < testCase; i++) {
      long a = scanner.nextLong();
      long b = scanner.nextLong();

      if (a > (2 * b)) {
        output.add("NO");
      } else {
        a %= 3;
        b %= 3;

        if (a < b) {
          long temp = a;
          a = b;
          b = temp;
        }
        if ((a == 2 && b == 1) || (a == b && b == 0)) {
          output.add("YES");
        } else {
          output.add("NO");
        }
      }
    }

    for (String s : output) {
      System.out.println(s);
    }
  }
}
