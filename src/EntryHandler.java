import java.util.Scanner;

public class EntryHandler {
    // Метод, проверяющий ввод целочисленных значений и значений с плавающей точкой
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
                            repeat = DepositCalc.getIsSourceDataIncorrect();
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return DepositCalc.getIsSourceDataIncorrect();
    }
    //TODO переделать метод под запрос на сохранение файла
    // Метод, проверяющий необходимость сохранения результатов вычислений в файл
    public static boolean isExportResultToFile() {
        System.out.print("Экспортировать результат вычислений в файл? (Да/Нет) ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        DepositCalc.setIsExportResultToFile(true);
        switch (answer) {
            case "Нет":
                DepositCalc.setIsExportResultToFile(true);
                break;
            case "Да":
                DepositCalc.setIsExportResultToFile(false);
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
                            DepositCalc.setIsExportResultToFile(true);
                            repeat = false;
                            break;
                        case "Да":
                            DepositCalc.setIsExportResultToFile(false);
                            repeat = DepositCalc.getIsExportResultToFile();
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return DepositCalc.getIsExportResultToFile();
    }
}
