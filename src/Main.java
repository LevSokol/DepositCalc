import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int numberOfComparingDeposits = DepositCalculation.determineNumberOfDeposits();
        List<DepositCalculation> objects = new ArrayList<DepositCalculation>();
        HashMap<DepositCalculation, String> baseOfObjects = new HashMap<>();
        for (int i = 0; i < numberOfComparingDeposits; i++) {
            objects.add(new DepositCalculation());
            System.out.print("Введите имя для депозита №" + (i + 1) + ": ");
            String name = EntryHandler.enrtyStringEmpty();
            baseOfObjects.put(objects.get(i), name);
            //System.out.println(baseOfObjects.get(objects.get(i)));
        }
        //Debug step
//        for (int j = 0; j < objects.size(); j++) {
//            System.out.println(objects.get(j));
//        }
    }
}
