package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));

        Stream<Integer> stream = numbers.stream();
        Stream<String> stream1 = Stream.of("Hien", "Huy", "An", "Duong");

        Stream.Builder<Integer> builder = Stream.builder();
        Stream<Integer> stream2 = builder.add(1).add(2).add(3).build();
    }
}
