package ui.tableView;

public class OrderRepTable {
		
	private String reportDate;
	private String reportName;
	private String reportType;
	
	public OrderRepTable(String reportDate, String reportName, String reportType) {
		super();
		this.reportDate = reportDate;
		this.reportName = reportName;
		this.reportType = reportType;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
