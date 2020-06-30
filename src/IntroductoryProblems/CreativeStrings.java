package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class CreativeStrings {
  // To generate all permutations of given string and

  public static void main(String[] args) throws IOException {
    // Task: 1622
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine();

    SortedSet<String> output = new TreeSet<>();
    generatePermutation("", s, output);

    System.out.println(output.size());
    for (String s1 : output) {
      System.out.println(s1);
    }
  }

  public static void generatePermutation(String permutation, String s, SortedSet<String> output) {

    if (s.length() == 0) {
      output.add(permutation);
    } else {
      for (int i = 0; i < s.length(); i++) {
        generatePermutation(
                permutation + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()), output);
      }
    }
  }
}
