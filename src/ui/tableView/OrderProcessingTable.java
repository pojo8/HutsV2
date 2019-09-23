package ui.tableView;

public class OrderProcessingTable {
		
	
	private String prodName;
	private String prodDate;

	private String currentStock;
	private String initialStock;
	private String prodId;
	
	public OrderProcessingTable(String prodName, String prodDate,  String currentStock, String initialStock, String prodId) {
		super();
		this.prodDate = prodDate;
		this.prodName = prodName;
		this.currentStock = currentStock;
		this.initialStock = initialStock;
		this.prodId = prodId;
	}
	
	
	@Override
	public String toString() {
		return "OrderProcessingTable [prodName=" +  prodName+ ", prodDate=" + prodDate + ", currentStock="
				+ currentStock + ", initialStock=" + initialStock + ", prodId=" + prodId + "]";
	}
	
	public String getProdDate() {
		return prodDate;
	}

	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(String currentStock) {
		this.currentStock = currentStock;
	}

	public String getInitialStock() {
		return initialStock;
	}


	public void setInitialStock(String initialStock) {
		this.initialStock = initialStock;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
}