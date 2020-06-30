package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoKnights {
    // Refer: https://www.youtube.com/watch?v=DGgxDjpTzhk
    // To find the number of ways 2 knights can be placed in a n*n chessboard, which is =
    // (n*n)*(n*n-)/2 where 2 = no. of knights.
    // To find the number of places that a knight can attack in a chessboard when placed in a position
    // = 2*2*(n-2)*(n-1).
    public static void main(String[] args) throws IOException {
        // Task: 1072
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (long i = 1; i <= n; i++) {
            long output = ((i * i) * (i * i - 1)) / 2 - 4 * (i - 2) * (i - 1);
            System.out.println(output);
        }
    }
}
