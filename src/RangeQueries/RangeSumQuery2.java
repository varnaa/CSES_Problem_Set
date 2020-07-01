package RangeQueries;

public class RangeSumQuery2 {
  // With update query
  public static void main(String[] args) {
    int[] array = {3, 2, 4, 5, 1, 1, 5, 3};
    int n = array.length;
    SegmentTree tree = new SegmentTree(array, n);
    tree.sumQuery(1, 4);
    tree.sumQuery(5, 6);
    tree.updateSumQuery(3, 1);
    tree.sumQuery(1, 4);
  }
}

