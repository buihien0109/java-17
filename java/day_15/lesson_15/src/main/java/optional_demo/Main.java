package optional_demo;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();

        Optional<String> optional1 = Optional.of("Hello");

        Optional<String> optional2 = Optional.ofNullable("Hi");

        // get() : Trả về giá trị bên trong optional
//        System.out.println(optional.get());
//        if(optional.isPresent()) {
//            System.out.println(optional.get());
//        } else {
//            System.out.println("No value");
//        }

        // isEmpty() : Nếu bên trong optional không có giá tri -> true, ngược lại -> false
        // isPresent() : Nếu bên trong optional có giá tri -> true, ngược lại -> false
        if(optional.isEmpty()) {
            System.out.println("No value");
        } else {
            System.out.println(optional.get());
        }

        if(optional1.isPresent()) {
            System.out.println(optional1.get());
        } else {
            System.out.println("No value");
        }

        // ifPresent() : Nếu có giá trị bên trong optional => Làm hành động gì đó với giá trị naày (consumer)
        optional1.ifPresent(value -> System.out.println(value));

        // orElse() : Nếu không có giá trị bên trong optional => trả về giá trị mặc định
        String message = optional.orElse("world");
        System.out.println(message);

        try {
            String message1 = optional.orElseThrow(() -> {
                throw new RuntimeException("Có lỗi xảy ra");
            });
            System.out.println(message1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
