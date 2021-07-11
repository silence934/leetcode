package xyz.nyist.test;

import xyz.nyist.entity.DateTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/24 17:40
 */
public class Test {

    public static void main(String[] args) {
        List<DateTest> list = Arrays.asList(
                new DateTest(1, "2"),
                new DateTest(1, "2"),
                new DateTest(2, "2"),
                new DateTest(3, "2")
        );


        System.out.println(list);
        System.out.println(list.stream().mapToInt(DateTest::getId).sum());

        list.stream().filter(distinctByKey(DateTest::getId))
                .forEach(System.out::println);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}
