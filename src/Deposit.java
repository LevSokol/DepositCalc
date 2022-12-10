import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Deposit {
    // Входные данные
    private String depositsName;                // название депозита
    private String bankName;                    // название банка
    private double initialPayment;              // исходная сумма вклада
    private double monthlyPayment;              // ежемесячное пополнение вклада с банковского счета (примерное или точное)
    private short limitMultiplicity;            // коэффициент лимита
    private float initialPaymentPercent;        // процент на исходную сумму
    private float monthlyPaymentPercent;        // процент на сумму ежемесячного пополнения
    private float monthlyCapitalizationPercent; // процент на капитализацию
    private float limitAmountPercent;           // процент на превышение суммы лимита
    private short depositTerm;                  // срок вклада (в месяцах)

    // Рассчетные данные
    private double monthlyCapitalization;       // ежемесячная капитализация по депозиту
    private double termCapitalization;          // суммарная капитализация на текущий срок вклада
    private double termPayment;                 // суммарное пополнение на текущий срок вклада
    private double limitAmount;                 // сумма лимита (= исходная сумма * коэффициент лимита)

    // Дополнительные поля класса
    private String fileName;                    // имя файла для сохранения результатов рассчета вклада

    // Конструкторы
    public Deposit(String depositsName, String bankName) {
        this.depositsName = depositsName;
        this.bankName = bankName;
    }

    // Сеттеры и геттеры
    public void setInitialPayment(double initialPayment) {
        while (initialPayment < 0) {
            System.out.print("Ошибка: число < 0, повторите ввод (допустимые значения: 0 и натуральные числа): ");
            initialPayment = Double.parseDouble(entryNumber());
        }
        this.initialPayment = initialPayment;
    }

    public double getInitialPayment() {
        return initialPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        while (monthlyPayment < 0) {
            System.out.print("Ошибка: число < 0. Повторите ввод (допустимые значения: 0 и натуральные числа): ");
            monthlyPayment = Double.parseDouble(entryNumber());
        }
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setLimitMultiplicity(short limitMultiplicity) {
        while (limitMultiplicity < 0) {
            System.out.print("Ошибка: число < 0. Повторите ввод (допустимые значения: 0 и натуральные числа): ");
            limitMultiplicity = Short.parseShort(entryNumber());
        }
        this.limitMultiplicity = limitMultiplicity;
    }

    public double getLimitMultiplicity() {
        return limitMultiplicity;
    }

    public void setInitialPaymentPercent(float initialPaymentPercent) {
        while (initialPaymentPercent < 0 || initialPaymentPercent > 100) {
            System.out.print("Ошибка: число < 0 или > 100. Повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            initialPaymentPercent = Float.parseFloat(entryNumber());
        }
        this.initialPaymentPercent = initialPaymentPercent / 100;
    }

    public double getInitialPaymentPercent() {
        return initialPaymentPercent * 100;
    }

    public void setMonthlyPaymentPercent(float monthlyPaymentPercent) {
        while (monthlyPaymentPercent < 0 || monthlyPaymentPercent > 100) {
            System.out.print("Ошибка: число < 0 или > 100. Повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            monthlyPaymentPercent = Float.parseFloat(entryNumber());
        }
        this.monthlyPaymentPercent = monthlyPaymentPercent / 100;
    }

    public double getMonthlyPaymentPercent() {
        return monthlyPaymentPercent * 100;
    }

    public void setMonthlyCapitalizationPercent(float monthlyCapitalizationPercent) {
        while (monthlyCapitalizationPercent < 0 || monthlyCapitalizationPercent > 100) {
            System.out.print("Ошибка: число < 0 или > 100. Повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            monthlyCapitalizationPercent = Float.parseFloat(entryNumber());
        }
        this.monthlyCapitalizationPercent = monthlyCapitalizationPercent / 100;
    }

    public double getMonthlyCapitalizationPercent() {
        return monthlyCapitalizationPercent * 100;
    }

    public void setLimitAmountPercent(float limitAmountPercent) {
        while (limitAmountPercent < 0 || limitAmountPercent > 100) {
            System.out.print("Ошибка: число < 0 или > 100. Повторите ввод (допустимые значения: от 0 до 100 включительно): ");
            limitAmountPercent = Float.parseFloat(entryNumber());
        }
        this.limitAmountPercent = limitAmountPercent / 100;
    }

    public double getLimitAmountPercent() {
        return limitAmountPercent * 100;
    }

    public void setDepositTerm(short depositTerm) {
        while (depositTerm < 0) {
            System.out.print("Ошибка: число < 1. Повторите ввод (допустимые значения: натуральные числа): ");
            depositTerm = Short.parseShort(entryNumber());
        }
        this.depositTerm = depositTerm;
    }

    public double getDepositTerm() {
        return depositTerm;
    }

    /**
     * Метод ввода исходных данных с проверкой по регулярному выражению
     */
    public String entryNumber() {
        return EntrySourceData.regexStringMatchCheck("([0-9]+|[0-9]+\\.[0-9]+)");
    }

    /**
     * Метод инициализации полей и проверки корректности ввода
     */
    public void entryData() {
        boolean isSourceDataСorrect = false;
        while (!isSourceDataСorrect) {
            System.out.print("Введите исходную сумму: ");
            setInitialPayment(Double.parseDouble(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите сумму ежемесячного пополнения (усредненное значение): ");
            setMonthlyPayment(Double.parseDouble(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите коэффициент лимита: ");
            String shortCheck = entryNumber();
            while (Double.parseDouble(shortCheck) < 1 || Double.parseDouble(shortCheck) > 100) {
                System.out.print("Ошибка: число < 1 или > 100. Повторите ввод (допустимые значения: целые числа от 1 до 100 включительно):");
                shortCheck = entryNumber();
            }
            setLimitMultiplicity(Short.parseShort(shortCheck));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите процент на исходную сумму: ");
            setInitialPaymentPercent(Float.parseFloat(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите процент на ежемесячное пополнение: ");
            setMonthlyPaymentPercent(Float.parseFloat(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите процент на капитализацию: ");
            setMonthlyCapitalizationPercent(Float.parseFloat(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите процент на превышение лимита: ");
            setLimitAmountPercent(Float.parseFloat(entryNumber()));
            CosmeticAdditions.printSeparator();

            System.out.print("Введите срок вклада (в месяцах): ");
            shortCheck = entryNumber();
            while (Double.parseDouble(shortCheck) < 1 || Double.parseDouble(shortCheck) > 36) {
                System.out.print("Ошибка: число < 1 или > 36. Повторите ввод (допустимые значения: целые числа от 1 до 36 включительно):");
                shortCheck = entryNumber();
            }
            setDepositTerm(Short.parseShort(shortCheck));
            CosmeticAdditions.printSeparator();

            System.out.println("Подтвердите корректность введенных данных: ");
            System.out.println("Депозит " + "\"" + depositsName + "\"");
            System.out.println("Банк " + "\"" + bankName + "\"");
            System.out.println("Исходная сумма = " + (new DecimalFormat("###,###.##").format(initialPayment)) + " руб.");
            System.out.println("Cумма ежемесячного пополнения = " + (new DecimalFormat("###,###.##").format(monthlyPayment)) + " руб.");
            System.out.println("Коэффициент лимита = " + limitMultiplicity);
            System.out.println("Процент на исходную сумму = " + String.format("%.1f", initialPaymentPercent * 100) + "%");
            System.out.println("Процент на ежемесячное пополнение = " + String.format("%.1f", monthlyPaymentPercent * 100) + "%");
            System.out.println("Процент на капитализацию = " + String.format("%.1f", monthlyCapitalizationPercent * 100) + "%");
            System.out.println("Процент на превышение лимита = " + String.format("%.1f", limitAmountPercent * 100) + "%");
            System.out.println("Срок вклада (в месяцах) = " + depositTerm);
            CosmeticAdditions.printSeparator();

            System.out.print("Данные корректны? (Да/Нет) ");
            isSourceDataСorrect = EntrySourceData.isActionPerform();
            if (!isSourceDataСorrect) {
                System.out.println("Повторите ввод!");
            }
        }
    }

    /**
     * Метод определения варианта вывода результата (CLI|file)
     */
    public void isSaveToFile() {
        boolean isSaveToFile = false;
        System.out.print("Сохранить результаты рассчета в файл? (Да/Нет) ");
        isSaveToFile = EntrySourceData.isActionPerform();
        if (isSaveToFile) {
            System.out.print("Введите имя файла: ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
            incomeCalculationOutputFile(fileName);
        } else {
            System.out.println();
            incomeCalculationOutputCLI();
        }
    }

    /**
     * Метод расчета доходности по депозиту
     */
    public void profitabilityCalculation() {
        entryData();
        isSaveToFile();
    }

    /**
     * Метод рассчета выходных значений капитализации для депозита с выводом вычислений в CLI
     */
    public void incomeCalculationOutputCLI() {
        double sumEndMonth = 0;
        limitAmount = initialPayment * limitMultiplicity;
        System.out.println("Депозит " + "\"" + depositsName + "\"");
        System.out.println("Банк " + "\"" + bankName + "\"");
        System.out.println("Сумма лимита = " + (new DecimalFormat("###,###.##").format(limitAmount)));
        CosmeticAdditions.printSeparator();

        for (int i = 1; i <= depositTerm; i++) {
            termPayment = i * monthlyPayment;
            System.out.println("Месяц " + i);
            System.out.println("Суммарное пополнение = " + (new DecimalFormat("###,###.##").format(termPayment)));
            if (i == 1) {
                if (limitAmount > (initialPayment + termPayment)) {
                    monthlyCapitalization = (initialPayment * initialPaymentPercent +
                            termPayment * monthlyPaymentPercent) / 12;
                } else {
                    monthlyCapitalization = (initialPayment + termPayment) * limitAmountPercent / 12;
                }
            } else {
                if (limitAmount > sumEndMonth) {
                    monthlyCapitalization = (initialPayment * initialPaymentPercent +
                            termPayment * monthlyPaymentPercent +
                            monthlyCapitalization * monthlyCapitalizationPercent) / 12;
                } else {
                    monthlyCapitalization = (initialPayment + termPayment + monthlyCapitalization) * limitAmountPercent / 12;
                }
            }
            System.out.println("Капитализация за месяц = " + (new DecimalFormat("###,###.##").format(monthlyCapitalization)));

            termCapitalization += monthlyCapitalization;
            System.out.println("Суммарная капитализация за пройденный период = " + (new DecimalFormat("###,###.##").format(termCapitalization)));

            sumEndMonth = initialPayment + termPayment + termCapitalization;
            System.out.println("Сумма на депозите на конец " + i + "-го месяца = " + (new DecimalFormat("###,###.##").format(sumEndMonth)));
            //TODO добавление обработки исключений (ввод пустой строки в сеттере и в методе entryData)
            CosmeticAdditions.printSeparator();
        }
    }

    /**
     * Метод рассчета выходных значений капитализации для одного объекта с выводом вычислений в файл
     *
     * @param fileName - полное имя файла
     */
    public void incomeCalculationOutputFile(String fileName) {
        double sumEndMonth = 0;
        try {
            FileWriter file = new FileWriter(fileName, false);
            file.write("Исходная сумма = " + (new DecimalFormat("###,###.##").format(initialPayment) + " руб.\n"));
            file.append("Cумма ежемесячного пополнения = " + (new DecimalFormat("###,###.##").format(monthlyPayment)) + " руб.\n");
            file.append("Коэффициент лимита = " + (new DecimalFormat("###,###.##").format(limitMultiplicity)) + "\n");
            file.append("Процент на исходную сумму = " + String.format("%.1f", initialPaymentPercent * 100) + "%\n");
            file.append("Процент на ежемесячное пополнение = " + String.format("%.1f", monthlyPaymentPercent * 100) + "%\n");
            file.append("Процент на капитализацию = " + String.format("%.1f", monthlyCapitalizationPercent * 100) + "%\n");
            file.append("Процент на превышение лимита = " + String.format("%.1f", limitAmountPercent * 100) + "%\n");
            file.append("Срок вклада (в месяцах) = " + depositTerm + "\n");
            limitAmount = initialPayment * limitMultiplicity;
            file.append("Депозит " + "\"" + depositsName + "\"" + "\n");
            file.append("Банк " + "\"" + bankName + "\"" + "\n");
            file.append("Сумма лимита = " + (new DecimalFormat("###,###.##").format(limitAmount)) + "\n");
            file.append(CosmeticAdditions.separator + "\n");

            for (int i = 1; i <= depositTerm; i++) {
                termPayment = i * monthlyPayment;
                file.append("Месяц " + i + "\n");
                file.append("Суммарное пополнение = " + (new DecimalFormat("###,###.##").format(termPayment)) + "\n");
                if (i == 1) {
                    if (limitAmount > (initialPayment + termPayment)) {
                        monthlyCapitalization = (initialPayment * initialPaymentPercent +
                                termPayment * monthlyPaymentPercent) / 12;
                    } else {
                        monthlyCapitalization = (initialPayment + termPayment) * limitAmountPercent / 12;
                    }
                } else {
                    if (limitAmount > sumEndMonth) {
                        monthlyCapitalization = (initialPayment * initialPaymentPercent +
                                termPayment * monthlyPaymentPercent +
                                monthlyCapitalization * monthlyCapitalizationPercent) / 12;
                    } else {
                        monthlyCapitalization = (initialPayment + termPayment + monthlyCapitalization) * limitAmountPercent / 12;
                    }
                }
                file.append("Капитализация за месяц = " + (new DecimalFormat("###,###.##").format(monthlyCapitalization)) + "\n");

                termCapitalization += monthlyCapitalization;
                file.append("Суммарная капитализация за пройденный период = " + (new DecimalFormat("###,###.##").format(termCapitalization)) + "\n");

                sumEndMonth = initialPayment + termPayment + termCapitalization;
                file.append("Сумма на депозите на конец " + i + "-го месяца = " + (new DecimalFormat("###,###.##").format(sumEndMonth)) + "\n");
                // добавление обработки исключений (ввод пустой строки в сеттере и в методе entryData)
                file.append(CosmeticAdditions.separator + "\n");
                file.flush();
            }
            System.out.println("Вычисления сохранены в файл " + fileName + " корневого каталога проекта!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Вычисления не были сохранены в файл " + fileName + "!");
        }
    }

    public void main(String[] args) {

    }
}