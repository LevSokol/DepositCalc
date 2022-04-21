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

    public static boolean checkEntryConfirmation() {
        System.out.print("Данные корректны? (Да/Нет) ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        DepositCalc.setCheckEntry(true);
        switch (answer) {
            case "Нет":
                CosmeticAdditions.printSeparator();
                System.out.println("Повторите ввод!");
                DepositCalc.setCheckEntry(true);
                break;
            case "Да":
                DepositCalc.setCheckEntry(false);
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
                            DepositCalc.setCheckEntry(true);
                            repeat = false;
                            break;
                        case "Да":
                            DepositCalc.setCheckEntry(false);
                            repeat = DepositCalc.getCheckEntry();
                            break;
                        default:
                            repeat = true;
                    }
                }
                break;
        }
        return DepositCalc.getCheckEntry();
    }
}
