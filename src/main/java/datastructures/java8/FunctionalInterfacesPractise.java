package datastructures.java8;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalInterfacesPractise {
    private static final String SEPARATOR = "==================================== | ";

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        Predicate<? super Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<? super Integer> predicate = x -> x % 2 == 1;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, String> stringFunction = x -> x + "" + x;
        Consumer<Integer> sysOutConsumer = x -> System.out.println(x);
        BinaryOperator<Integer> sumTwoVariables = (x, y) -> x + y;
        UnaryOperator<Integer> getTriplevalue = x -> x * 3;

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt();
        };

        BiPredicate<Integer, String> biPredicate = (num, str) -> {
            return (num > 5 && str.length() < 10);
        };

        BiFunction<String, Integer, String> biFunction = (num, str) -> {
            return num + " : " + str;
        };

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        numbers.stream().filter(evenPredicate).forEach(System.out::println);

        System.out.println(SEPARATOR + "Print even  numbers");
        filterAndPrint(x -> x % 2 == 0, numbers);

        System.out.println(SEPARATOR + "Print   numbers divisible by 3");
        filterAndPrint(x -> x % 3 == 0, numbers);

        System.out.println(SEPARATOR + "Squared list using Function");
        System.out.println(squaredNumbers(numbers, x -> x * x));

        System.out.println(SEPARATOR + " Function  for unaryOperator  to triple the given value");
        System.out.println(getTriplevalue.apply(25));

        System.out.println(SEPARATOR + " Function  to return Random number ");
        System.out.println(randomIntegerSupplier.get());

        System.out.println(SEPARATOR + "Test BiPredicate");
        System.out.println(biPredicate.test(10, "Hello"));

        System.out.println(SEPARATOR + "Test BiFunction");
        System.out.println(biFunction.apply("Hello", 15));

        System.out.println(SEPARATOR + "Using custom static method ");
        courses.stream().map(str -> str.toUpperCase()).forEach(FunctionalInterfacesPractise::printMe);
        courses.stream().map(String::toUpperCase).forEach(FunctionalInterfacesPractise::printMe);
        Supplier<String> supplier = String::new;  // Constructor references
    }

    private static void filterAndPrint(Predicate<? super Integer> predicate, List<Integer> numbers) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }

    private static List<Integer> squaredNumbers(List<Integer> numbers, Function<Integer, Integer> operableFunction) {
        return numbers.stream().map(operableFunction).collect(Collectors.toList());
    }

    private static void printMe(String str) {
        System.out.println(str);
    }
}
