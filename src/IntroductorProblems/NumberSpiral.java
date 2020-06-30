package IntroductorProblems;

import java.io.IOException;
import java.util.Scanner;

public class NumberSpiral {
  // Refer:
  // https://www.youtube.com/watch?v=8fmP577kxLs&list=PLeSz1PJQJqD5X12IWEbWcUWTJATtc0h0R&index=6
  public static void main(String[] args) throws IOException {
    // Task: 1071

    Scanner reader = new Scanner(System.in);

    int testCase = reader.nextInt();
    while (testCase > 0) {
      long row = reader.nextLong();
      long col = reader.nextLong();

      long output = 0;
      long max = Math.max(row, col);
      long apExpression = max * (max - 1) + 1;

      if (max % 2 == 0) {
        output = apExpression + row - col;
      } else {
        output = apExpression + col - row;
      }
      System.out.println(output);
      testCase--;
    }
  }
}
