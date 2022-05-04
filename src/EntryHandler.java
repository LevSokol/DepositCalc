import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class EntryHandler {
    // Метод, ограничивающий ввод пустой строки и подстроки, несоответствующие регулярному выражению
    public static String enrtyStringHandler(String regex) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (string.isEmpty() || !string.matches(regex)) {
            System.out.print("Ошибка: введённая строка пустая, содержит недопустимые символы или " +
                    "значение выходит за границы диапазона! Повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }

    // Метод, ограничивающий ввод пустой строки
    public static String enrtyStringEmpty() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (string.isEmpty()) {
            System.out.print("Ошибка: введённая строка пустая! Повторите ввод: ");
            string = scanner.nextLine();
        }
        return string;
    }

    // Метод, проверяющий необходимость повторного ввода данных
    public static boolean isRepeatEntrySourceData() {
        System.out.print("Данные корректны? (Да/Нет) ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        DepositCalc.setIsSourceDataIncorrect(true);
        switch (answer) {
            case "Нет":
                CosmeticAdditions.printSeparator();
                System.out.println("Повторите ввод!");
                DepositCalc.setIsSourceDataIncorrect(true);
                break;
            case "Да":
                DepositCalc.setIsSourceDataIncorrect(false);
                break;
            default:
                boolean repeat = true;

                while (repeat) {
                    System.out.print("Ввод должен содержать Да или Нет! ");
                    answer = scanner.nextLine();

                    switch (answer) {
                        case "Нет":
                            CosmeticAdditions.printSeparator();
                            System.out.println("Повторите ввод!");
                            DepositCalc.setIsSourceDataIncorrect(true);
                            repeat = false;
                            break;
                        case "Да":
                            DepositCalc.setIsSourceDataIncorrect(false);
                            repeat = false;
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return DepositCalc.getIsSourceDataIncorrect();
    }

    // Метод, проверяющий корректность бинарного выбора
    public static boolean checkEntryConfirmationWithoutRepeatEntry() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        DepositCalc.setIsSaveToFile(false);
        switch (answer) {
            case "Нет":
                DepositCalc.setIsSaveToFile(false);
                break;
            case "Да":
                DepositCalc.setIsSaveToFile(true);
                break;
            default:
                boolean repeat = true;
                while (repeat) {
                    System.out.print("Ввод должен содержать Да или Нет! ");
                    answer = scanner.nextLine();
                    switch (answer) {
                        case "Нет":
                            DepositCalc.setIsSaveToFile(false);
                            repeat = false;
                            break;
                        case "Да":
                            DepositCalc.setIsSaveToFile(true);
                            repeat = false;
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return DepositCalc.getIsSourceDataIncorrect();
    }
}
