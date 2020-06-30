package IntroductorProblems;

import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        // Task: 1092
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if ((n * (n + 1) / 2) % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int j = 0, sizeA = 0, sizeB = 0;
        StringBuilder setA = new StringBuilder();
        StringBuilder setB = new StringBuilder();

        if (n % 4 == 0) {
            j = 4;
        } else {
            j = 3;
        }

        for (int i = 0; i < (n - 1) / 4; i++) {
            setA.append(4 * i + 1 + j).append(" ");
            setA.append(4 * i + 4 + j).append(" ");
            sizeA += 2;
            setB.append(4 * i + 2 + j).append(" ");
            setB.append(4 * i + 3 + j).append(" ");
            sizeB += 2;
        }

        if (n % 4 == 0) {
            setA.append(1).append(" ");
            setA.append(4).append(" ");
            sizeA += 2;
            setB.append(3).append(" ");
            setB.append(2).append(" ");
            sizeB += 2;
        } else {
            setA.append(1).append(" ");
            setA.append(2).append(" ");
            sizeA += 2;
            setB.append(3).append(" ");
            sizeB += 1;
        }

        System.out.println("YES");
        System.out.println(sizeA);
        System.out.println(setA);
        System.out.println(sizeB);
        System.out.println(setB);
    }
}
