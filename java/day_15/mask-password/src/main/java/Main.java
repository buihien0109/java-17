import java.io.Console;

public class Main {
    public static void consoleFunc() {
        Console console;
        if ((console = System.console()) != null) {
            char[] passwordArray = console.readPassword("Enter your  password: ");
            for (int i = 0; i < passwordArray.length; i++) {
                System.out.print("*");
            }
            System.out.println();
            console.printf("Password entered was: \n", new String(passwordArray));
        }
    }

    public static void main(String[] args) {
        consoleFunc();
    }
}
