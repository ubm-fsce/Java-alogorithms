package practise.java8;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractise {
    private static final String SEPARATOR = "==================================== | ";

    static void practise3() {
        List<Employee> emps = Stream.of(
                new Employee(1, "uday", "dev", 1200D),
                new Employee(1, "test", "test", 1300D),
                new Employee(1, "test2", "test", 1350D),
                new Employee(1, "dev2", "dev", 1350D)
        ).collect(Collectors.toList());

        emps.stream().
                collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))))).
                entrySet().stream().forEach(System.out::println);



    }

    static void practise2() {
        String ip = "ilovejavaTechie";
        String[] res = ip.split("");

        String input = "abracadabra";
        Map<Character, Long> occurrenceMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurrenceMap.forEach((character, occurrence) ->
                System.out.println("Character: " + character + ", Occurrence: " + occurrence));
        System.out.println(SEPARATOR);

        // Count of occurrences of Each Character in a String
        System.out.println("Count of occurrences of Each Character in a String");
        Arrays.stream(res).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().forEach(System.out::println);

        // Duplicate elements from given string
        List<String> s = Arrays.stream(res)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Count of occurrences of Each Character in a String : \n" + s);

        // Unique elements from given string
        List<String> s2 = Arrays.stream(res)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Unique elements from given string : \n" + s2);

        // Find first non Repeat Character
        String s3 = Arrays.stream(res)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
        System.out.println("Find first non Repeat Character: \n" + s3);

        // Find 2nd highest number for a given Array
        int[] ar = {5, 9, 11, 2, 8, 15, 21};
        List<Integer> intar = Arrays.stream(ar).boxed()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(" Find 2nd highest number for a given Array \n" + intar);
        Integer i1 = Arrays.stream(ar).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst().get();
        System.out.println(" Find 2nd highest number for a given Array \n" + i1);

        // Find the longest String from a given Array
        String[] strar = {"java", "techie", "SpringBootadsfasfdsaff", "microservices"};
        String lonStr = Arrays.stream(strar).reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
                .get();
        System.out.println(" Find the longest String from a given Array \n" + lonStr);

        // find all elements from an array start with 1
        int[] nums = {6, 8, 11, 25, 13, 9, 1};
        List<String> istr = Arrays.stream(nums).boxed()
                .map(ival -> ival.toString()).filter(is -> is.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(" starts with 1 \n" + istr);

        // String.Join
        String[] starr = {"Udaya", "Bhasker", "Mattupalli"};
        System.out.println("String.Join \n" + String.join("~", starr));

        // IntStream
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);
        System.out.println(SEPARATOR);
        // Map and FlatMap
        List<List<String>> emailStrs = new ArrayList<>();
        emailStrs.add(Arrays.asList("a.a.com", "b.b.com"));
        emailStrs.add(Arrays.asList("c.C.com", "c.c.com"));
        emailStrs.add(Arrays.asList("d.d.com", "e.e.com"));
        emailStrs.add(Arrays.asList("f.f.com", "g.g.com"));
        System.out.println("Map and FlatMap : \n" +
                emailStrs.stream().flatMap(e -> e.stream()).collect(Collectors.toList()));

    }

    static void practise1() {
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
        // .reduce(0, Integer::sum); /*Option 3*/
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
        Integer[] array = {12, 9, 13, 4, 6, 9, 9, 9, 2, 4, 12, 15};
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
        String input = "asdafdsafsdfa";
        Map<Character, Long> occurrenceMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        occurrenceMap.forEach((character, occurrence) ->
                System.out.println("Character: " + character + ", Occurrence: " + occurrence));

        Integer i = 100;
        Long.valueOf(i);

        //  System.out.println(Arrays.stream(arr).sorted().boxed().skip(1).findFirst().get());
    }

    public static void main(String[] args) {
        // practise2();
        //  practise1();
        practise3();
    }

}

