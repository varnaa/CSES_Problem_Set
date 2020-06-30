package IntroductorProblems;

import java.util.Scanner;

public class IncreasingArray {
  public static void main(String[] args) {
    // Task: 1094
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();

    long turns = 0;
    long a = 0, b = 0;
    a = in.nextLong();
    for (int i = 1; i < size; i++) {
      b = in.nextLong();
      if (a > b) {
        turns += a - b;
      } else {
        a = b;
      }
    }

    System.out.println(turns);
  }
}
