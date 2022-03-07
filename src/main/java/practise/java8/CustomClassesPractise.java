package practise.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {

        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}

public class CustomClassesPractise {
    private static final String SEPARATOR = "==================================== | ";

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        System.out.println(SEPARATOR + "ALL MATCH GT 90 : " + courses.stream().allMatch(course -> course.getReviewScore() > 90));

        System.out.println(SEPARATOR + "ALL MATCH GT 95: " + courses.stream().allMatch(course -> course.getReviewScore() > 95));
        Predicate<Course> reviewPredicateGT90 = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewPredicateGT95 = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewPredicateLT90 = course -> course.getReviewScore() < 90;

        System.out.println(SEPARATOR + "ALL MATCH GT90 : " + courses.stream().allMatch(reviewPredicateGT90));
        System.out.println(SEPARATOR + "ANY MATCH ANY GT 95: " + courses.stream().anyMatch(reviewPredicateGT95));
        System.out.println(SEPARATOR + "NONE  MATCH : None LT 90 " + courses.stream().noneMatch(reviewPredicateLT90));

        Comparator<Course> comparingStudentsIncreasing = Comparator.comparing(Course::getReviewScore);
        Comparator<Course> comparingStudentsDecreasing = Comparator.comparing(Course::getReviewScore).reversed();
        courses.stream().sorted(Comparator.comparing(Course::getReviewScore)).forEach(System.out::println);
        System.out.println(SEPARATOR + " Courses Sorted ::  " + courses.stream().sorted(comparingStudentsIncreasing).collect(Collectors.toList()));
        System.out.println(SEPARATOR + " Courses Sorted reversed ::  " + courses.stream().sorted(comparingStudentsDecreasing).collect(Collectors.toList()));

        Comparator<Course> compareDecrease = Comparator.comparing(Course::getReviewScore);
        System.out.println(" ===>> " + courses.stream().sorted(compareDecrease.reversed()).collect(Collectors.toList()));

        System.out.println("==> TOP 3 ::: " + courses.stream().sorted(Comparator.comparing(Course::getName).reversed()).limit(3).collect(Collectors.toList()));

        System.out.println("===> SKip TOP 5 :: " + courses.stream().
                sorted(Comparator.comparing(Course::getCategory).reversed()).skip(5).limit(2).distinct().collect(Collectors.toList()));

        System.out.println("  " + courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed()).collect(Collectors.toList()));

        System.out.println(" ====> Take while :: " + courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore).reversed()).takeWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList())
        );

        System.out.println(" ====> Drop while ::  " + courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed())
                .dropWhile(course -> course.getReviewScore() > 96).collect(Collectors.toList()));

        System.out.println(" ====> Drop while ::  ");
        courses.stream().
                sorted(Comparator.comparing(Course::getReviewScore).reversed()).
                dropWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(" ====> takeWhile while ::  students and reviews ");
        courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore).thenComparing(Course::getNoOfStudents).reversed()).
                takeWhile(course -> course.getReviewScore() > 95).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println(" ====> takeWhile while ::  Max course students and reviews " +
                courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Comparator.comparing(Course::getReviewScore).reversed()))
                        .collect(Collectors.toList()).stream().max(Comparator.comparing(Course::getNoOfStudents))
        );

        System.out.println(" ====> takeWhile while ::  Min course students and reviews " +
                courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Comparator.comparing(Course::getReviewScore).reversed()))
                        .collect(Collectors.toList())
        );

        System.out.println(" ====> takeWhile while ::  Min course students and reviews " +
                courses.stream().filter(course -> course.getReviewScore() > 90).mapToInt(Course::getNoOfStudents).max());

        int[] numberArray = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(" ====> takeWhile while ::  Min course students and reviews " + Arrays.stream(numberArray).sum());

        System.out.println(" ====> Even int numbers " + IntStream.iterate(0, e -> e + 2).limit(15).peek(System.out::println).sum());

        System.out.println(" ====> Even int numbers " + IntStream.iterate(0, e -> e + 2).limit(15).boxed().collect(Collectors.toList()));

        System.out.println(SEPARATOR + " UDAY takeWhile while ::  Max Course " +
                courses.stream()
                        .max(Comparator.comparing(Course::getReviewScore).
                                thenComparing(Course::getNoOfStudents).reversed()));


        System.out.println(SEPARATOR + " UDAY   ::  MIN Course " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 100).
                        min(Comparator.comparing(Course::getReviewScore)
                                .thenComparing(Course::getNoOfStudents).reversed()));

        System.out.println(SEPARATOR + " UDAY  while :: MIN   ELSE  " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 100).
                        min(Comparator.comparing(Course::getReviewScore)
                                .thenComparing(Course::getNoOfStudents).reversed())
                        .orElse(courses.get(0))
        );

        System.out.println(SEPARATOR + " UDAY  while :: FindFirst   ELSE  " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85).
                        findFirst());

        System.out.println(SEPARATOR + " UDAY  while :: FindAny   ELSE  " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85).
                        findAny()
                        .orElse(courses.get(0)));

        System.out.println(SEPARATOR + "   mapToInt and reduce " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .reduce(0, (x, y) -> x + y));

        System.out.println(SEPARATOR + "   mapToInt and SUM " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .sum());

        System.out.println(SEPARATOR + "   mapToInt and Average " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .average());

        System.out.println(SEPARATOR + "     count " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .count());

        System.out.println(SEPARATOR + "     MIN " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .min());
        System.out.println(SEPARATOR + "     MIN " +
                courses.stream()
                        .filter(course -> course.getReviewScore() > 85)
                        .mapToInt(Course::getNoOfStudents)
                        .max());

        System.out.println(SEPARATOR + "  get MAP   groupingBy  " +
                courses.stream().collect(Collectors.groupingBy(Course::getReviewScore)));

        System.out.println(SEPARATOR + "  get MAP   with key and value  " +
                courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println(SEPARATOR + "  get MAP   with key and max by comparing  " +
                courses.stream().collect(
                        Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(SEPARATOR + "  get MAP   with key and only name   " +
                courses.stream().collect(
                        Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));


    }


}
