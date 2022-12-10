import java.util.Scanner;

public class EntrySourceData {
    /**
     * Метод, ограничивающий ввод строки, несоответствующей регулярному выражению
     *
     * @param regex
     * @return
     */
    public static String regexStringMatchCheck(String regex) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (string.isEmpty() || !string.matches(regex)) {
            System.out.print("Ошибка: введённая строка пустая, содержит недопустимые символы или " +
                    "значение выходит за границы диапазона! Повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }

    /**
     * Метод, ограничивающий ввод пустой строки
     *
     * @return
     */
    public static String checkEmptyStringEntry() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (string.isEmpty()) {
            System.out.print("Ошибка: введённая строка пустая! Повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }

    /**
     * Метод, проверяющий корректность ответа на закрытый вопрос
     *
     * @return
     */
    public static boolean isActionPerform() {
        boolean isActionPerform = false;
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        switch (answer) {
            case "Нет":
                isActionPerform = false;
                break;
            case "Да":
                isActionPerform = true;
                break;
            default:
                boolean repeat = true;
                while (repeat) {
                    System.out.print("Ввод должен содержать Да или Нет! ");
                    answer = scanner.nextLine();
                    switch (answer) {
                        case "Нет":
                            isActionPerform = false;
                            repeat = false;
                            break;
                        case "Да":
                            isActionPerform = true;
                            repeat = false;
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return isActionPerform;
    }
}
