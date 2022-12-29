package dsa.miscleneous;

import java.util.HashMap;
import java.util.Map;

public class ExcelRowTitle {
  public static String convertToTitle(int n) {
    String res = "";
    while (n != 0) {
      int temp = (n - 1) % 26;
      temp = (temp + 65);
      char ch = (char) temp;
      n = (n - 1) / 26;
      res = ch + res;
    }
    return res;
  }

  public static int titleToNumber1(String s) {
    int result = 0;

    Map<Character, Integer> alpha_map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      int c = i + 65; // Decimal 65 in ASCII corresponds to char 'A'
      alpha_map.put((char) c, i + 1);
    }

    int n = s.length();
    for (int i = 0; i < n; i++) {
      char cur_char = s.charAt(n - 1 - i);
      result += (alpha_map.get(cur_char) * (Math.pow(26, i)));
    }
    return result;
  }

  public static int titleToNumber2(String s) {
    int result = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      result = result * 26;
      // In Java, subtracting characters is subtracting ASCII values of characters
      result += (s.charAt(i) - 'A' + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    String tempStr = "ZV";
    int tempNum = titleToNumber1(tempStr);
    int tempNum2 = titleToNumber2(tempStr);

    System.out.println("tempNum1 : " + tempNum + " : Title : " + tempStr);
    System.out.println("tempNum2 : " + tempNum2 + " : Title : " + tempStr);
    System.out.println("N : " + tempNum + " : Title : " + convertToTitle(tempNum));
  }
}
