package IntroductorProblems;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        // Find the Missing Number.

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n - 1];
        long actualSum = (long) n * (n + 1) / 2;
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
            actualSum -= array[i];
        }
        System.out.println(actualSum);
    }
}
