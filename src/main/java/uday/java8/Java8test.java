package uday.java8;


import org.apache.commons.lang3.StringUtils;

public class Java8test {
    public static void main(String[] args) {
        System.out.println(StringUtils.equalsIgnoreCase(null, null));
        System.out.println(StringUtils.equalsIgnoreCase(null, "T"));
        System.out.println(StringUtils.equalsIgnoreCase("T", "t"));
        System.out.println(StringUtils.equalsIgnoreCase("T", null));
    }
}
