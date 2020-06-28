import java.util.Scanner;

public class Permutations {
  public static void main(String[] args) {
    // Task: 1070
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    findPermutation(n);
    findPermutation1(n);
    findPermutation2(n);
  }

  // Method 1
  // This solution doesn't work for n = 4 but works for all cases n > 4.
  // 0.49ms
  public static void findPermutation(int n) {
    int[] output = new int[n];
    if (n == 1) {
      System.out.println(1);
    }
    if (n == 2 || n == 3) {
      System.out.println("NO SOLUTION");
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
      StringBuilder stringBuilder = new StringBuilder();
      for (int values : output) {
        stringBuilder.append(values).append(" ");
      }

      System.out.println(stringBuilder);
    }
  }

  // Method 2: Works for all solution n > 3
  // Instead of arranging from increasing to decreasing of odd and even numbers, arrange it from
  // decreasing to increasing.
  // TLE for large inputs.

  public static void findPermutation1(int n) {

    if (n == 1) {
      System.out.println("1");
    }
    if (n <= 3) {
      System.out.println("NO SOLUTION");
    } else {
      StringBuilder odd = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        if (i % 2 == 0) {
          System.out.print(i + " ");
        } else {
          odd.append(i).append(" ");
        }
      }
      System.out.print(odd);
    }
  }

  // Method 3: Same as method 2 but instead of sout for even numbers using a string.
  // Passes for large inputs : 0.44ms
  public static void findPermutation2(int n) {

    if (n == 1) {
      System.out.println("1");
    }
    if (n <= 3) {
      System.out.println("NO SOLUTION");
    } else {
      StringBuilder odd = new StringBuilder();
      StringBuilder even = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        if (i % 2 == 0) {
          even.append(i).append(" ");
        } else {
          odd.append(i).append(" ");
        }
      }
      System.out.print(even);
      System.out.print(odd);
    }
  }
}
