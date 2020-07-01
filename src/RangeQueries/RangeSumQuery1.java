package RangeQueries;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class RangeSumQuery1 {
  static Scanner scanner = new Scanner(new InputStreamReader(System.in));

  public static void main(String[] args) {
    // Task: 1646
    int n, q;
    n = scanner.nextInt();
    q = scanner.nextInt();

    long[] array = new long[n];
    Arrays.setAll(array, i -> scanner.nextLong());

    //Optimal solution
    FindRangeSum(array, q, n);

    // 1: Naive Approach.
    for (int i = 0; i < q; i++) {
      int range1 = scanner.nextInt();
      int range2 = scanner.nextInt();

      if (range1 - range2 == 0) {
        // writer.write((array[range1 - 1] + " \n").getBytes());
        System.out.println(array[range1 - 1]);
      } else {
        long sum = 0;
        for (int i1 = range1 - 1; i1 < range2; i1++) {
          sum += array[i1];
        }
        // writer.write((sum + "\n").getBytes());
        System.out.println(sum);
      }
    }
  }

  // Best solution using segment tree.
  public static void FindRangeSum(long[] array, int q, int n) {

    long[] segmentTree = new long[2 * array.length];

    // O(n) to create the segment tree.
    {
      for (int i = n, j = 0; i < segmentTree.length; i++, j++) {
        segmentTree[i] = array[j];
      }

      for (int i = n - 1; i > 0; --i) {
        segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
      }
    }

    // O(logn) for each range query.
    for (int i = 0; i < q; i++) {
      int l = scanner.nextInt();
      int r = scanner.nextInt();

      if (l == r) {
        System.out.println(array[l - 1]);
        continue;
      }

      l += n - 1;
      r += n - 1;
      long sum = 0;

      while (l <= r) {
        if ((l % 2) == 1) {
          sum += segmentTree[l];
          l++;
        }

        if ((r % 2) == 0) {
          sum += segmentTree[r];
          r--;
        }
        l /= 2;
        r /= 2;
      }

      System.out.println(sum);
    }
  }
}
