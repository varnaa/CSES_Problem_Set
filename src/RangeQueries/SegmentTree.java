package RangeQueries;

import java.util.Arrays;

class SegmentTree {
  private int[] segmentTree;
  private int size;

  public SegmentTree(int[] array, int n) {
    this.segmentTree = new int[2 * array.length];
    this.size = n;

    for (int i = size, j = 0; i < segmentTree.length; i++, j++) {
      segmentTree[i] = array[j];
    }
  }

  public void generateSumSegmentTree() {

    // Generate Segment Tree values for sum of the range
    for (int i = size - 1; i > 0; i--) {
      segmentTree[i] = segmentTree[i * 2] + segmentTree[2 * i + 1];
    }
  }

  public void generateMinSegmentTree() {

    // Generate Segment Tree value for minimum of the range.
    for (int i = size - 1; i > 0; i--) {
      segmentTree[i] = Math.min(segmentTree[2 * i], segmentTree[2 * i + 1]);
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

  public void minQuery(int l, int r) {
    l += size - 1;
    r += size - 1;

    int min = Integer.MAX_VALUE;

    while (l <= r) {
      if (l % 2 == 1) {
        min = Math.min(min, segmentTree[l]);
        l++;
      }
      if (r % 2 == 0) {
        min = Math.min(min, segmentTree[l]);
        r--;
      }
      l /= 2;
      r /= 2;
    }
    System.out.println(min);
  }

  public void updateSumQuery(int index, int value) {
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

  public void updateMinQuery(int index, int value) {
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

      segmentTree[index] = Math.min(segmentTree[left], segmentTree[right]);
      index /= 2;
    }

    System.out.println("Value updated!");
    System.out.println(Arrays.toString(segmentTree));
  }

  public void printTree() {
    System.out.println(Arrays.toString(segmentTree));
  }
}
