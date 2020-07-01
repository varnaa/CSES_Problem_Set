package RangeQueries;

import java.util.Arrays;

public class RangeSumQuery2 {
  // With update query
  public static void main(String[] args) {
    int[] array = {3, 2, 4, 5, 1, 1, 5, 3};
    int n = array.length;
    SegmentTree tree = new SegmentTree(array, n);
    tree.sumQuery(1, 4);
    tree.sumQuery(5, 6);
    tree.updateQuery(3, 1);
    tree.sumQuery(1, 4);
  }
}

class SegmentTree {
  private int[] segmentTree;
  private int size;

  public SegmentTree(int[] array, int n) {
    this.segmentTree = new int[2 * array.length];
    this.size = n;

    // Generate Segment Tree
    for (int i = n, j = 0; i < segmentTree.length; i++, j++) {
      segmentTree[i] = array[j];
    }
    for (int i = n - 1; i > 0; i--) {
      segmentTree[i] = segmentTree[i * 2] + segmentTree[2 * i + 1];
    }
  }

  public void sumQuery(int l, int r) {
    l += size - 1;
    r += size - 1;

    int sum = 0;

    while (l <= r) {
      if (l % 2 == 1) {
        sum += segmentTree[l];
        l++;
      }
      if (r % 2 == 0) {
        sum += segmentTree[r];
        r--;
      }
      l /= 2;
      r /= 2;
    }
    System.out.println(sum);
  }

  public void updateQuery(int index, int value) {
    index += size - 1;
    segmentTree[index] = value;

    while (index > 0) {
      int left = index;
      int right = index;

      if (index % 2 == 0) {
        right++;
      } else {
        left--;
      }

      segmentTree[index] = segmentTree[left] + segmentTree[right];
      index /= 2;
    }

    System.out.println("Value updated!");
    System.out.println(Arrays.toString(segmentTree));
  }
}
