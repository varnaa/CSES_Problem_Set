package RangeQueries;

public class RangeMinimumQuery2 {
    public static void main(String[] args) {
        //Task: 1647
        int[] array = {3, 2, 4, 5, 1, 1, 5, 3};

        int n = array.length;
        SegmentTree tree = new SegmentTree(array, n);
        tree.generateMinSegmentTree();
        tree.minQuery(1, 4);
        tree.minQuery(5, 6);
        tree.updateMinQuery(3, 2);
        tree.minQuery(1, 4);

    }
}
