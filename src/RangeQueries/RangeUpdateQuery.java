package RangeQueries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RangeUpdateQuery {

  public static void main(String[] args) {
    // Task: 1651
    int[] array = {3, 2, 4, 5, 1, 1, 5, 3};
    // Naive approach.
    segmentTree_Update tree_update = new segmentTree_Update(array, array.length);
    tree_update.findValue(4);
    tree_update.updateRange(2, 5, 1);
    tree_update.findValue(4);
    tree_update.setValues(2, 4, 3);
    tree_update.getSum(1, 5);
    tree_update.findDistinct(3, 6);
    tree_update.findCount(1, 1);
  }
}

class segmentTree_Update {
  private int size;
  private int[] array;

  public segmentTree_Update(int[] array, int n) {
    this.array = Arrays.copyOf(array, array.length);
    this.size = array.length;
  }

  public void updateRange(int l, int r, int value) {
    for (int i = l - 1; i < r - 1; i++) {
      array[i] += value;
    }
    System.out.println(Arrays.toString(array) + " After updating Range");
  }

  public void findValue(int index) {
    System.out.println(array[index - 1] + " is the value present at index " + (index - 1));
  }

  public void setValues(int l, int r, int value) {
    for (int i = l - 1; i < r - 1; i++) {
      array[i] = value;
    }
    System.out.println(Arrays.toString(array) + " After seting values");
  }

  public void getSum(int l, int r) {
    int[] segmentTree = new int[2 * size];

    for (int i = size, j = 0; i < segmentTree.length; i++, j++) {
      segmentTree[i] = array[j];
    }

    for (int i = size - 1; i > 0; i--) {
      segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
    }

    int sum = 0;
    l += size - 1;
    r += size - 1;

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

    System.out.println(sum + "is the sum");
  }

  public void findDistinct(int l, int r) {
    Set<Integer> set = new HashSet<>();
    for (int i = l - 1; i < r - 1; i++) {
      set.add(array[i]);
    }

    System.out.println("Distinct values are: " + set.size());
  }

  public void findCount(int range1, int range2) {
    int count = 0;
    for (int i : array) {
      if (i >= range1 && i <= range2) {
        count++;
      }
    }
    System.out.println(count + " value is present between the range " + range1 + " and range" + range2);
  }
}
