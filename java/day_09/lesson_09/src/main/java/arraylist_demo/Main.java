package arraylist_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers);

        // Method
        numbers.add(0, 10);
        System.out.println(numbers);


        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(100, 200, 300));
        numbers.addAll(numbers1);
        System.out.println(numbers);

        System.out.println(numbers.contains(100));

        System.out.println(numbers.get(0));

//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ArrayList<String> names = new ArrayList<>(List.of("Hien", "An", "Huy"));
        System.out.println(names);
    }
}
