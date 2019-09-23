package ui.tableView;

public class ProductTableView {



    private String product;
    private String date;
    private String primaryEmail;
    private String pNotifyAt;
    private String secondaryEmail;
    private String vendorEmail;
    private String vNotifyAt;
    private String price;
    private String currency;
    private String amount;



    public ProductTableView(String product, String date, String primaryEmail, String pNotifyAt, String secondaryEmail,
                            String vendorEmail, String vNotifyAt, String price, String currency, String amount){

        super();
        this.product = product;
        this.date = date;
        this.primaryEmail = primaryEmail;
        this.pNotifyAt = pNotifyAt;
        this.secondaryEmail = secondaryEmail;
        this.vendorEmail = vendorEmail;
        this.vNotifyAt = vNotifyAt;
        this.price = price;
        this.currency = currency;
        this.amount = amount;
    }



    public String getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }

    public String getPrimaryNotify(){ return pNotifyAt; }

    public String getPrimaryEmail() {
        return primaryEmail;
    }


    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public String getVendorNotifyAt() {
        return vNotifyAt;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAmount() {
        return amount;
    }



    public String getpNotifyAt() {
        return pNotifyAt;
    }

    public String getvNotifyAt() {
        return vNotifyAt;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public void setpNotifyAt(String pNotifyAt) {
        this.pNotifyAt = pNotifyAt;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public void setvNotifyAt(String vNotifyAt) {
        this.vNotifyAt = vNotifyAt;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


}
