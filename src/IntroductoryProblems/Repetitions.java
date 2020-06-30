package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
  public static void main(String[] args) throws IOException {
    // Task: 1069
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    findLongestRepition(input);
  }

  public static void findLongestRepition(String input) {
    int index = 0;
    int count = 0, longest = 0;
    char curr = input.charAt(0);
    while (index < input.length()) {
      if (input.charAt(index) == curr) {
        count++;
        index++;
      } else {
        longest = Math.max(count, longest);
        count = 0;
        curr = input.charAt(index);
      }
    }

    System.out.println(Math.max(longest, count));
  }
}
