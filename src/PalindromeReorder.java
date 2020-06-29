import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PalindromeReorder {
  // Refer: https://www.geeksforgeeks.org/rearrange-characters-form-palindrome-possible/
  public static void main(String[] args) throws IOException {
    // task: 1755

    HashMap<Character, Integer> map = new HashMap<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String s = reader.readLine();
    StringBuilder firstHalf = new StringBuilder();
    StringBuilder secondHalf = new StringBuilder();
    char odd = '0';
    int oddValue = 0;

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int oddCount = 0;
    for (char c : map.keySet()) {
      int i = map.get(c);
      if (i % 2 != 0) {
        odd = c;
        oddValue = i;
        oddCount++;
        if (oddCount > 1) {
          System.out.println("NO SOLUTION");
          return;
        }
      } else {
        for (int i1 = 0; i1 < i / 2; i1++) {
          firstHalf.append(c);
          secondHalf.append(c);
        }
      }
    }

    if (oddCount == 1 && s.length() % 2 == 0) {
      System.out.println("NO SOLUTION");
    } else {
      System.out.println(
              oddCount == 1
                      ? firstHalf.append(String.valueOf(odd).repeat(oddValue)).append(secondHalf.reverse())
                      : firstHalf.append(secondHalf.reverse()));
    }
  }
}
