import java.util.Scanner;

public class DepositCalc {

    private static double initialPayment;               // исходная сумма
    private static double monthlyPayment;               // ежемесячное пополнение с банковского счета
    private static short limitMultiplicity;             // коэффициент лимита
    private static float initialPaymentPercent;         // процент на исходную сумму
    private static float monthlyPaymentPercent;         // процент на ежемесячное пополнение
    private static float monthlyCapitalizationPercent;  // процент на капитализацию
    private static float limitAmountPercent;            // процент на превышение лимита
    private static short depositTerm;                   // срок вклада (в месяцах)

    private static double monthlyCapitalization;        // ежемесячная капитализация по депозиту
    private static double termCapitalization;           // суммарная капитализация на текущий срок вклада
    private static double termPayment;                  // суммарное пополнение на текущий срок вклада
    private static double limitAmount;                  // сумма лимита (limitMultiplicity-кратная изначальная сумма на вклад)


    public static void setInitialPayment(double initialPayment) {
        while (initialPayment < 0) {
            System.out.print("Error: число < 0, повторите ввод (допустимые значения: 0 и натуральные числа): ");
            Scanner scanner = new Scanner(System.in);
            initialPayment = Double.parseDouble(scanner.nextLine());
        }
        DepositCalc.initialPayment = initialPayment;
    }

    public static double getInitialPayment() {
        return initialPayment;
    }

    public static void setMonthlyPayment(double monthlyPayment) {
        while (monthlyPayment < 0) {
            System.out.print("Error: число < 0, повторите ввод (допустимые значения: 0 и натуральные числа): ");
            Scanner scanner = new Scanner(System.in);
            monthlyPayment = Double.parseDouble(scanner.nextLine());
        }
        DepositCalc.monthlyPayment = monthlyPayment;
    }

    public static double getMonthlyPayment() {
        return monthlyPayment;
    }

    public static void setLimitMultiplicity(short limitMultiplicity) {
        while (limitMultiplicity < 0) {
            System.out.print("Error: число < 0, повторите ввод (допустимые значения: 0 и натуральные числа): ");
            Scanner scanner = new Scanner(System.in);
            limitMultiplicity = Short.parseShort(scanner.nextLine());
        }
        DepositCalc.limitMultiplicity = limitMultiplicity;
    }

    public static double getLimitMultiplicity() {
        return limitMultiplicity;
    }

    public static void setInitialPaymentPercent(float initialPaymentPercent) {
        while (initialPaymentPercent < 0 || initialPaymentPercent > 100) {
            System.out.print("Error: число < 0 или > 100, повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            Scanner scanner = new Scanner(System.in);
            initialPaymentPercent = Float.parseFloat(scanner.nextLine());
        }
        DepositCalc.initialPaymentPercent = initialPaymentPercent / 100;
    }

    public static double getInitialPaymentPercent() {
        return initialPaymentPercent * 100;
    }

    public static void setMonthlyPaymentPercent(float monthlyPaymentPercent) {
        while (monthlyPaymentPercent < 0 || monthlyPaymentPercent > 100) {
            System.out.print("Error: число < 0 или > 100, повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            Scanner scanner = new Scanner(System.in);
            monthlyPaymentPercent = Float.parseFloat(scanner.nextLine());
        }
        DepositCalc.monthlyPaymentPercent = monthlyPaymentPercent / 100;
    }

    public static double getMonthlyPaymentPercent() {
        return monthlyPaymentPercent * 100;
    }

    public static void setMonthlyCapitalizationPercent(float monthlyCapitalizationPercent) {
        while (monthlyCapitalizationPercent < 0 || monthlyCapitalizationPercent > 100) {
            System.out.print("Error: число < 0 или > 100, повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            Scanner scanner = new Scanner(System.in);
            monthlyCapitalizationPercent = Float.parseFloat(scanner.nextLine());
        }
        DepositCalc.monthlyCapitalizationPercent = monthlyCapitalizationPercent / 100;
    }

    public static double getMonthlyCapitalizationPercent() {
        return monthlyCapitalizationPercent * 100;
    }

    public static void setLimitAmountPercent(float limitAmountPercent) {
        while (limitAmountPercent < 0 || limitAmountPercent > 100) {
            System.out.print("Error: число < 0 или > 100, повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            Scanner scanner = new Scanner(System.in);
            limitAmountPercent = Float.parseFloat(scanner.nextLine());
        }
        DepositCalc.limitAmountPercent = limitAmountPercent / 100;
    }

    public static double getLimitAmountPercent() {
        return limitAmountPercent * 100;
    }

    public static void setDepositTerm(short depositTerm) {
        while (depositTerm < 0) {
            System.out.print("Error: число < 1, повторите ввод (допустимые значения: натуральные числа): ");
            Scanner scanner = new Scanner(System.in);
            depositTerm = Short.parseShort(scanner.nextLine());
        }
        DepositCalc.depositTerm = depositTerm;
    }

    public static double getDepositTerm() {
        return depositTerm;
    }

    public static void printSeparator(){
        System.out.println("*******************************************************************");
    }

    public static void entryData() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean checkEntry = true;

        while (checkEntry) {
            System.out.print("Введите исходную сумму: ");
            double initialPayment = Double.parseDouble(scanner.nextLine());
            setInitialPayment(initialPayment);

            System.out.print("Введите сумму ежемесячного пополнения (усредненное значение): ");
            double monthlyPayment = Double.parseDouble(scanner.nextLine());
            setMonthlyPayment(monthlyPayment);

            System.out.print("Введите коэффициент лимита: ");
            short limitMultiplicity = Short.parseShort(scanner.nextLine());
            setLimitMultiplicity(limitMultiplicity);

            System.out.print("Введите процент на исходную сумму: ");
            float initialPaymentPercent = Float.parseFloat(scanner.nextLine());
            setInitialPaymentPercent(initialPaymentPercent);

            System.out.print("Введите процент на ежемесячное пополнение: ");
            float monthlyPaymentPercent = Float.parseFloat(scanner.nextLine());
            setMonthlyPaymentPercent(monthlyPaymentPercent);

            System.out.print("Введите процент на капитализацию: ");
            float monthlyCapitalizationPercent = Float.parseFloat(scanner.nextLine());
            setMonthlyCapitalizationPercent(monthlyCapitalizationPercent);

            System.out.print("Введите процент на превышение лимита: ");
            float limitAmountPercent = Float.parseFloat(scanner.nextLine());
            setLimitAmountPercent(limitAmountPercent);

            System.out.print("Введите срок вклада (в месяцах): ");
            short depositTerm = Short.parseShort(scanner.nextLine());
            setDepositTerm(depositTerm);

            printSeparator();
            System.out.println("Подтвердите корректность введенных данных: ");
            System.out.println("Исходная сумма = " + String.format("%.2f", getInitialPayment()));
            System.out.println("Cумма ежемесячного пополнения = " + String.format("%.2f", getMonthlyPayment()));
            System.out.println("Коэффициент лимита = " + String.format("%.0f", getLimitMultiplicity()));
            System.out.println("Процент на исходную сумму = " + String.format("%.2f", getInitialPaymentPercent()));
            System.out.println("Процент на ежемесячное пополнение = " + String.format("%.2f", getMonthlyPaymentPercent()));
            System.out.println("Процент на капитализацию = " + String.format("%.2f", getMonthlyCapitalizationPercent()));
            System.out.println("Процент на превышение лимита = " + String.format("%.2f", getLimitAmountPercent()));
            System.out.println("Срок вклада (в месяцах) = " + String.format("%.0f", getDepositTerm()));
            printSeparator();
            System.out.print("Данные корректны? (Да/Нет) ");
            answer = scanner.nextLine();
            switch (answer) {
                case "Нет":
                    printSeparator();
                    System.out.println("Повторите ввод снова!");
                    checkEntry = true;
                    break;
                case "Да":
                    checkEntry = false;
                    break;
                default:
                    boolean repeat = true;

                    while (repeat) {
                        System.out.print("Ввод должен содержать Да или Нет.. ");
                        answer = scanner.nextLine();

                        switch (answer) {
                            case "Нет":
                                printSeparator();
                                System.out.println("Повторите ввод снова!");
                                checkEntry = true;
                                repeat = false;
                                break;
                            case "Да":
                                checkEntry = repeat = false;
                                break;
                            default:
                                repeat = true;
                        }
                    }break;
            }
        }
    }

    public static void incomeCalculation() {
        entryData();
        double sumEndMonth = 0;
        limitAmount = initialPayment * limitMultiplicity;
        System.out.println("Сумма лимита = " + limitAmount);
        printSeparator();

        for (int i = 1; i <= depositTerm; i++) {
            termPayment = i * monthlyPayment;
            System.out.println("Суммарное пополнение = " + termPayment);
            if (i == 1) {
                monthlyCapitalization = (initialPayment * initialPaymentPercent +
                        termPayment * monthlyPaymentPercent) / depositTerm;
                System.out.println("Капитализация за 1-ый месяц = " + monthlyCapitalization);

                termCapitalization = monthlyCapitalization;
                System.out.println("Капитализация за пройденный период (1-ый месяц) = " + termCapitalization);

                sumEndMonth = initialPayment + termPayment + termCapitalization;
                System.out.println("Сумма на депозите на конец 1-го месяца = " + sumEndMonth);
                printSeparator();

            } else {
                if (limitAmount > sumEndMonth) {
                    monthlyCapitalization = (initialPayment * initialPaymentPercent +
                            termPayment * monthlyPaymentPercent +
                            monthlyCapitalization * monthlyCapitalizationPercent) / depositTerm;
                    System.out.println("Капитализация за " + i + " месяц = " + monthlyCapitalization);

                    termCapitalization += monthlyCapitalization;
                    System.out.println("Капитализация за пройденный период (" + i + " месяца/ев) = " + termCapitalization);

                    sumEndMonth = initialPayment + termPayment + termCapitalization;
                    System.out.println("Сумма на депозите на конец " + i + "-го месяца = " + sumEndMonth);
                    printSeparator();

                } else {
                    System.out.println("Пока не доделал =)");
                }
                // добавление обработки исключений (ввод пустой строки в сеттере и в методе entryData)
            }
        }
    }


    public static void main(String[] args) {
        DepositCalc depositCalc = new DepositCalc();
        depositCalc.incomeCalculation();
    }
}