package practise.java8.fpexcercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fp01Excercise {

  public static void main(String[] args) {
    List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 29, 15, 23);
    List<Integer> nums2 = List.of();
    List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
        "Kubernetes");

    // Sum of number
    System.out.println(nums.stream().reduce((x, y) -> x + y));
    nums.stream().reduce(Integer::sum);
    System.out.println(nums2.stream().reduce((x, y) -> x + y));
    System.out.println(nums.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
    System.out.println(nums.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y));
    System.out.println(nums.stream().reduce((x, y) -> x));
    System.out.println(nums.stream().reduce((x, y) -> y));
    System.out.println(nums.stream().filter(x -> x % 2 == 1).reduce(0, Integer::sum));
    System.out.println(nums.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum));
    nums.stream().filter(x -> x % 2 == 0).map(x -> x * x * x).forEach(System.out::println);
    nums.stream().filter(x -> x % 2 == 1).map(x -> x * x * x).forEach(System.out::println);
    nums.stream().distinct().forEach(System.out::print);
    nums.stream().sorted().forEach(System.out::print);
    courses.stream().sorted().distinct().forEach(System.out::println);
    courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    courses.stream().sorted(Comparator.comparing(course -> course.length())).forEach(System.out::println);
    courses.stream().sorted(Comparator.comparing(course -> course.length())).forEach(System.out::println);
    courses.stream().map(x -> x.length()).collect(Collectors.toList()).stream().sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
    int[] na = { 12, 9, 13, 4, 6, 2, 4, 12, 15 };
    System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15, 12, 111, 1111).count());
    System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15, 12, 111, 1111).reduce(Integer::sum));
    System.out.println(Arrays.stream(na).average());
    System.out.println(Arrays.stream(na).min());
    // Integer num1 = nums.stream().reduce(0, (x, y) -> x + y);
    // Optional<Integer> num2 = nums.stream().reduce((x, y) -> x + y);
    // System.out.println(num2 + "," + num1);
    // System.out.println(nums.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ?
    // x : y));
    // System.out.println(nums.stream().reduce(0, (x, y) -> x));
    // System.out.println(nums.stream().reduce(0, (x, y) -> y));
    // System.out.println(nums.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ?
    // x : y));
    // System.out.println("HIHIHI : " + nums.stream().reduce(1, (x, y) -> x * y));
    // System.out.println(nums.stream().map(x -> x * x).reduce(0, Integer::sum));
    // System.out.println(nums.stream().map(x -> x * x * x).reduce(0,
    // Integer::sum));
    // System.out.println(nums.stream().filter(x -> x % 2 == 1).reduce(0,
    // Integer::sum));
    // System.out.println(nums.stream().filter(x -> x % 2 == 0).reduce(0,
    // Integer::sum));

    // nums.stream().distinct().forEach(System.out::println);
    // nums.stream().distinct().sorted().forEach(System.out::println);

    System.out.println();

  }

}
