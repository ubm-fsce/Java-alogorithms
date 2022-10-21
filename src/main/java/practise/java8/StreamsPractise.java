package practise.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractise {
        private static final String SEPARATOR = "==================================== | ";

        public static void main(String[] args) {
                List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
                List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
                                "Docker", "Kubernetes");

                System.out.println(SEPARATOR + "Distinct Odd numbers ");

                System.out.println(SEPARATOR + "Print ln");
                courses.forEach(System.out::println);
                courses.stream().forEach(System.out::println);

                System.out.println(SEPARATOR + "Spring");
                courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);

                System.out.println(SEPARATOR + "length()>10) !");
                courses.stream().filter(course -> course.length() > 10).forEach(System.out::println);

                System.out.println(SEPARATOR + " MAP !");
                courses.stream().map(course -> course + "  length : " + course.length()).forEach(System.out::println);

                System.out.println(SEPARATOR + " PRINT ODD numbers !");
                numbers.stream().filter(n -> n % 2 == 1).forEach(System.out::println);

                System.out.println(SEPARATOR + " PRINT EVEN numbers !");
                numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

                System.out.println(SEPARATOR + " print Cubes Of OddNumbers !!!");
                numbers.stream().filter(x -> x % 2 == 1).map(x -> x * x * x).forEach(System.out::println);

                System.out.println(SEPARATOR + " reduce() !!!");
                int sum = numbers.stream()
                                /// .reduce(0,FunctionalProgrammingExercise01::sum); /*Option 1*/
                                .reduce(100, (x, y) -> x + y); /* Option 2 */
                // .reduce(0, Integer::sum); /*Option 3JJShe*/
                System.out.println(SEPARATOR + " reduce() !!!  :sum : " + sum);
                System.out.println(SEPARATOR + " Print minimum value !!!");

                int minValue = numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);

                System.out.println(SEPARATOR + " Print minimum value ! " + minValue);

                System.out.println(SEPARATOR + " square every number   and print minimum value!!!");
                int squearedMinimum = numbers.stream().map(x -> x * x).reduce(Integer.MAX_VALUE,
                                (x, y) -> x > y ? y : x);
                System.out.println(SEPARATOR + " square every number   and print minimum value!!!" + squearedMinimum);

                System.out.println(SEPARATOR + " square and sum!!!");
                int squaredSum = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
                System.out.println(SEPARATOR + " square and sum!!!" + squaredSum);

                System.out.println(SEPARATOR + " Cube  and sum!!!");
                int cubedSum = numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
                System.out.println(SEPARATOR + " Cube  and sum!!!" + cubedSum);

                System.out.println(SEPARATOR + " print Distinct numbers!!!");
                numbers.stream().distinct().forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted list of numbers!!!");
                numbers.stream().sorted().forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted distinct list of numbers!!!");
                numbers.stream().distinct().sorted().forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted distinct list of courses!!!");
                courses.stream().distinct().sorted().forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted with comparator list of courses!!!");
                courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted with comparator reverse  list of courses!!!");
                courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

                System.out.println(SEPARATOR + " sorted with comparator with custom comparator  list of courses!!!");
                courses.stream().sorted(Comparator.comparing(x -> x.length())).forEach(System.out::println);
                courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

                System.out.println(SEPARATOR
                                + " sorted with comparator with custom comparator and reversed  list of courses!!!");
                courses.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

                System.out.println(SEPARATOR + " get doubled list of numbers!!!");
                List<Integer> doubledList = numbers.stream().map(x -> x * x).collect(Collectors.toList());
                doubledList.stream().forEach(System.out::println);
                doubledList.forEach(System.out::println);

                System.out.println(SEPARATOR + " get cubed list of even numbers!!!");
                List<Integer> cubedList = numbers.stream().filter(x -> (x % 2 == 0)).map(x -> x * x * x)
                                .collect(Collectors.toList());
                cubedList.stream().forEach(System.out::println);
                cubedList.forEach(System.out::println);

                System.out.println(SEPARATOR + " list with each course length !!!");
                List<Integer> courseLengthList = courses.stream().map(String::length).collect(Collectors.toList());
                courseLengthList.forEach(System.out::println);

                System.out.println(SEPARATOR + " Distinct Odd list !!!");
                Integer[] array = { 12, 9, 13, 4, 6, 9, 9, 9, 2, 4, 12, 15 };
                Arrays.asList(array).stream().filter(x -> x % 2 == 1).distinct().forEach(System.out::println);

                System.out.println(SEPARATOR + " Distinct Odd list !!! List Print ");
                System.out.println(Arrays.asList(array).stream().filter(x -> x % 2 == 1).distinct()
                                .collect(Collectors.toList()));

                System.out.println(
                                SEPARATOR + "print list with , " +
                                                courses.stream().collect(Collectors.joining(",")));
                System.out.println(
                                SEPARATOR + "Flat map , " +
                                                courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
                                                                .collect(Collectors.toList()));

                System.out.println(
                                SEPARATOR + " Distinct Flat map , " +
                                                courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
                                                                .distinct().collect(Collectors.toList()));

        }

}
