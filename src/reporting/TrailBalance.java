package reporting;


public class TrailBalance {


    //Debit is postive
    //Credit is negative
    public enum TrailType {
        Debit,Credit;
    }

    public String itemName;
    public TrailType trailType;
    public double amount;



    public TrailBalance(String itemName, TrailType trailType, double amount) {
        this.itemName = itemName;
        this.trailType = trailType;
        this.amount =amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public TrailType getTrailType() {
        return trailType;
    }

    public void setTrailType(TrailType trailType) {
        this.trailType = trailType;
    }
}
