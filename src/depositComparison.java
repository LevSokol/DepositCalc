import java.util.ArrayList;

public class depositComparison {
    private static int numberOfComparingDeposits;   // количество депозитов для сравнения


    /**
     * Метод, определяющий количество сравниваемых вкладов
     */
    public static int determineNumberOfDeposits() {
        System.out.print("Введите число сравниваемых депозитов (не более 4): ");
        numberOfComparingDeposits = Integer.parseInt(EntrySourceData.regexStringMatchCheck("[1-4]+"));
        return numberOfComparingDeposits;
    }


    public void comparisonDepositsOutput(ArrayList<Deposit> depositsList) {
        determineNumberOfDeposits();
        for (int i = 0; i < numberOfComparingDeposits; i++) {
            System.out.print("Введите имя для депозита №" + (i + 1) + ": ");
            String name = EntrySourceData.checkEmptyStringEntry();

        }
    }
}
