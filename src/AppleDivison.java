import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AppleDivison {
  public static void main(String[] args) throws IOException {
    // Refer: https://github.com/iamprayush/cses-problemset-solutions/blob/master/solutions/Introductory%20Problems/apple-division.cpp

    Scanner reader = new Scanner(new InputStreamReader(System.in));
    int n = reader.nextInt();
    Long[] array = new Long[n];
    long sum = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      array[i] = reader.nextLong();
      sum += array[i];
    }

    for (int i = 0; i < 1 << n; i++) {
      long cs = 0;
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) == 1) {
          cs += array[j];
        }
        if (cs <= sum / 2) {
          ans = Long.max(ans, cs);
        }
      }
    }

    long answer = sum - 2 * ans;
    System.out.println(answer);
  }
}
