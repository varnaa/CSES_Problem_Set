package RangeQueries;

public class RangeMinimumQuery2 {
    public static void main(String[] args) {
        //Task: 1647
        int[] array = {4, 6, 33, 7, 8, 2, 1, 0, 3, 5};

        int n = array.length;
        SegmentTree tree = new SegmentTree(array, n);
        tree.generateMinSegmentTree();
        tree.minQuery(1, 4);
        tree.minQuery(5, 6);
        tree.updateMinQuery(1, -1);
        tree.minQuery(1, 10);


    }
}
