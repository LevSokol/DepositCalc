import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int numberOfComparingDeposits = 0;

    public static void main(String[] args) {
        System.out.print("Введите количество сравниваемых депозитов: ");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        numberOfComparingDeposits = Integer.parseInt(result);
        List<DepositCalc> objects = new ArrayList<DepositCalc>();
        for (int i = 1; i <= numberOfComparingDeposits; i++) {
            objects.add(new DepositCalc());
        }
        for (int j = 0; j < objects.size(); j++) {
            System.out.println(objects.get(j));
        }
    }
}