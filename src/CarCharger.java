public class CarCharger {
    /** the following rateTable has 24 entries representing the
     * charging costs for hours 0 through 23.
     */
    private int [] rateTable;


    public CarCharger(int[] table){
        rateTable = table;
    }


    public int getChargingCost(int startHour, int numHours){
        int cost = 0;
        int strHr = startHour;
        for (int i = 0; i < numHours; i++){
            if (strHr>=24) {
                strHr -= 24;
            }
            cost += rateTable[strHr];
            strHr++;
        }
        return cost;
    }


    public int getChargeStartTime(int hours){
        int result = 0;
        int low = getChargingCost(0,hours);
        for (int i = 0; i < 23; i++){
            int x = getChargingCost(i, hours);
            if (x < low){
                low = x;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int [] table = {50,60,160,60,80,100,100,120,150,150,150,
                200,40,240,220,220,200,200,180,180,140,100,80,60};
        CarCharger cc = new CarCharger(table);
        System.out.println("Charging costs");
        System.out.println("12, 1, " + cc.getChargingCost(12,1));
        System.out.println("0, 2, " +cc.getChargingCost(0, 2));
        System.out.println("22, 7, " + cc.getChargingCost(22, 7));
        System.out.println("22, 30, " + cc.getChargingCost(22,30));
        System.out.println("Best start Time");
        System.out.println("1 " + cc.getChargeStartTime(1));
        System.out.println("2 " + cc.getChargeStartTime(2));
        System.out.println("7 " + cc.getChargeStartTime(7));
        System.out.println("30 " + cc.getChargeStartTime(30));


    }
}