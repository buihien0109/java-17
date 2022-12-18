package encapsulation_demo;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1);
        person.setName("Bùi Hiên");
        person.setAge(26);
        person.setEmail("hien@gmail.com");

        System.out.println(person);
    }
}
