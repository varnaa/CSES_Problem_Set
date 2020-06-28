import java.util.Scanner;

public class Permutations {
  public static void main(String[] args) {
    // Task: 1070
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    findPermutation(n);
  }

  public static void findPermutation(int n) {
    int[] output = new int[n];
    if (n == 1) {
      System.out.println(1);
    }
    if (n == 2 || n == 3) {
      System.out.println("NO SOLUTION");
    }
    if (n == 4) {
      System.out.println("2 4 1 3");
    } else {
      int evenIndex = 1, oddIndex = n - 2;
      output[0] = n % 2 == 0 ? n : n - 1;
      output[n - 1] = 1;

      while (evenIndex < n / 2) {
        output[evenIndex] = output[evenIndex - 1] - 2;
        evenIndex++;
      }
      while (oddIndex >= n / 2) {
        output[oddIndex] = output[oddIndex + 1] + 2;
        oddIndex--;
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int values : output) {
      stringBuilder.append(values).append(" ");
    }

    System.out.println(stringBuilder);
  }
}
