package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZeros {
  // Refer:
  // https://www.youtube.com/watch?v=0PxnJxGobUU&list=PLeSz1PJQJqD5X12IWEbWcUWTJATtc0h0R&index=4
  public static void main(String[] args) throws IOException {
    // Task: 1618
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long input = Long.parseLong(reader.readLine());
    findZeros(input);
    long five = 5L, output = 0;
    while (input / five >= 1) {
      output += input / five;
      five *= 5;
    }
    System.out.println(output);
  }

  //Solution 2:
  public static void findZeros(long n) {
    long count = 0;
    for (long i = 5; i <= n; i *= 5) {
      count += n / i;
    }

    System.out.println(count);
  }


}
