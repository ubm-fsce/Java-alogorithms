package dsa.twopointer;

public class Test {
  public static void main(String[] args) {
    System.out.println(reverseWords("Hello     World"));
  }

  public static String reverseWords(String sentence) {
    String[] sarr = sentence.split(" ");
    System.out.println(sarr.length);
    StringBuilder sb = new StringBuilder();
    for (int i = sarr.length - 1; i >= 0; i--) {
      System.out.println("sarr[i] " + sarr[i] + " sarr[i] size : " + sarr[i].size());
      String tempStr = sarr[i].trim();
      System.out.println("tempStr : " + tempStr + " tempStr size : " + tempStr.length());
      sb.append(tempStr);
      sb.append(" ");
    }
    return sb.toString().trim();
  }
}
