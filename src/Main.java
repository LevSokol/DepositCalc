public class Main {

    public static void main(String[] args) {

        Deposit deposit = new Deposit("Вкладывай", "Сбер");
        deposit.depositCalculation();

/*        int numberOfComparingDeposits = Deposit.determineNumberOfDeposits();
        List<Deposit> objects = new ArrayList<Deposit>();
        HashMap<Deposit, String> baseOfObjects = new HashMap<>();
        for (int i = 0; i < numberOfComparingDeposits; i++) {
            objects.add(new Deposit());
            System.out.print("Введите имя для депозита №" + (i + 1) + ": ");
            String name = EntryHandler.enrtyStringEmpty();
            baseOfObjects.put(objects.get(i), name);
            System.out.println(baseOfObjects.get(objects.get(i)));
        }*/
        //Debug step
//        for (int j = 0; j < objects.size(); j++) {
//            System.out.println(objects.get(j));
//        }
    }
}
