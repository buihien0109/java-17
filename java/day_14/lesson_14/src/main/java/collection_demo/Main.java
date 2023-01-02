package collection_demo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Victor");
        list.add("Anna");
        list.add("Chris");

        System.out.println("Danh sách ban đầu: ");
        System.out.println(list);

        //Sắp xếp với Collections.sort()
        Collections.sort(list);
        System.out.println("Danh sách sau khi sắp xếp tăng dần: ");
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("Danh sách sau khi sắp xếp giảm dần: ");
        System.out.println(list);

        // Đảo vị trí
        Collections.shuffle(list);
        System.out.println("Danh sách sau khi đảo vị trí: ");
        System.out.println(list);

//        Collections.fill(list, "Hiên");
//        System.out.println("Danh sách sau khi fill: ");
//        System.out.println(list);
    }
}
