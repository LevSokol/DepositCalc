import java.util.Scanner;

public class EntryHandler {

    public static String enrtyStringHandler() {
        Scanner scanner = new Scanner(System.in);
        String regex = "[0-9]+";
        String string = scanner.nextLine();
        while (string.isEmpty() || !string.matches(regex)) {
            System.out.print("Ошибка: введённая строка пустая или содержит нецифровые символы! Повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }
}
