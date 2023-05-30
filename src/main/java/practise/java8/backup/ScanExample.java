package practise.java8.backup;

import java.util.Scanner;

public class ScanExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        System.out.println("i : " + i + " d : " + d + "  S : " + s);
        scan.close();

    }
}