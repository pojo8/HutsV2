package reporting;


import static reporting.TrailBalance.TrailType.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrailBalanceProcessing {

     static List<TrailBalance> Balance2 = Arrays.asList(
            new TrailBalance("I1", Debit, 10.0 ),
            new TrailBalance("I2", Credit, 12.0 )
    );

     //Todo refine print standard
    public static void prettyPrintTrail(List<TrailBalance> Balance  ){
        Balance.stream().map(trailBalance -> {
            if(trailBalance.getTrailType()==Credit) {
                return new StringBuffer(trailBalance.itemName + "        |     " + "     | " + trailBalance.getAmount())+ "   | " ;
            }
            else{
                return new StringBuffer(trailBalance.itemName + "               |     "+ trailBalance.getAmount()+  "    |     "+"     | " );

            }
        }).forEach(System.out::println);
    }


    /**
     * takes in
     * @param Balance
     * @return sum
     * of the amounts present
     */
    public static Double getSum(List<TrailBalance> Balance ){
        Double sum = Balance.stream().mapToDouble(trailBalance -> {
            if(trailBalance.getTrailType()==Credit) {
                return  -trailBalance.getAmount();
            }
            else{
                return  trailBalance.getAmount();

            }
        }).sum();

        return sum;
    }

    public static Double [] getTrailTypeSums(List<TrailBalance> Balance ){
        Double creditSum = Balance.stream().filter(trailBalance -> trailBalance.getTrailType()==Credit).mapToDouble(trailBalance ->
                trailBalance.getAmount()).sum();
        Double debitSum = Balance.stream().filter(trailBalance -> trailBalance.getTrailType()==Debit).mapToDouble(trailBalance ->
                trailBalance.getAmount()).sum();

        Double [] sumed ={creditSum,debitSum};
        return sumed;
    }


    public static void main(String[] args) {
        System.out.println("Account Title |   DEBIT     |     Credit    | ");
        prettyPrintTrail(Balance2);

        System.out.println(getSum(Balance2));

        Arrays.stream(getTrailTypeSums(Balance2)).forEach(System.out::println);
        System.out.println(getTrailTypeSums(Balance2)[1]);

    }

}
