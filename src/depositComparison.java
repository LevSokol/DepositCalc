import java.util.ArrayList;
import java.util.List;

public class depositComparison {
    private static int numberOfComparingDeposits;   // количество депозитов для сравнения

    /**
     * Метод, определяющий количество сравниваемых вкладов
     */
    public static int determineNumberOfDeposits() {
        System.out.print("Введите число сравниваемых депозитов (не более 4): "); //TODO пересмотреть максимальное число для сравннеия депозитов
        numberOfComparingDeposits = Integer.parseInt(EntrySourceData.regexStringMatchCheck("[1-4]+"));
        return numberOfComparingDeposits;
    }

    /**
     * Метод ввода исходных данных для сравнения депозитов
     *
     * @return
     */
    public List<Deposit> dataEntryForComparisonDeposits() {
        determineNumberOfDeposits();
        List<Deposit> depositList = new ArrayList<Deposit>();

        for (int i = 1; i <= numberOfComparingDeposits; i++) {
            System.out.print("Введите название депозита №" + (i + 1) + ": ");
            String depositsName = EntrySourceData.checkEmptyStringEntry();
            System.out.print("Введите название банка депозита №" + (i + 1) + ": ");
            String bankName = EntrySourceData.checkEmptyStringEntry();
            depositList.add(new Deposit(depositsName, bankName));
        }
        return depositList;
    }

    /**
     * Вывод результатов сравнения депозитов
     */
    // TODO: определить, какие параметры выводить в сводную таблицу
    public void depositComparisonOutput() {
        List<Deposit> depositList = dataEntryForComparisonDeposits();

        // Создание списка имен депозита/банка для создания таблицы
        String[] depositAndBankNames = new String[numberOfComparingDeposits];
        for (int i = 1; i <= 4; i++) {
            Deposit deposit = depositList.get(i);
            depositAndBankNames[i] = deposit.getDepositsName() + "/" + deposit.getBankName();
            System.out.println(depositAndBankNames[i]);
        }
        // Формирование сводной таблицы
        CommandLineTable table = new CommandLineTable();
        table.setShowVerticalLines(true);
        table.setHeaders("one", "two", "three");
    }
}
