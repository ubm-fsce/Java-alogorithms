package datastructures.java8;

import java.util.Scanner;

public class PrintfExample {
    public static void main(String[] args) {
        //  scanExample();
        System.out.printf("Hello %s!%n", "Uday");

    }

    private static void scanExample() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.format("%-15s%03d%n", s1, x);

        }
        System.out.println("================================");
    }
}

