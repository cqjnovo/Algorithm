package review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book {
    int id;
}
public class TestHash {
    public static void main(String[] args) {
//        streamChain();
        String a = "11";
        Integer i = Integer.valueOf(a);
        System.out.println("10".compareTo("3"));
//        testListCapacity();
    }


    public static void streamChain() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(f -> f < 5).map(m -> -1 * m).collect(Collectors.toList());
        list.forEach(s -> System.out.print(s + " "));
    }

    public static void testListCapacity() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            list.add(i);
        }
    }
}
