package reporting;

import javax.print.PrintException;

import static querySet.reporting.Query_Reports.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportGenerator {

    public static String writeToFile() throws IOException, SQLException {

        StringBuffer reportBuffer = createReportStringBuffer();

        // Files.createFile(Paths.get("src/main/reporting/generatedReports/createdReport.txt"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();

        String pathToReport = "src/main/reporting/generatedReports/Report-"+ dtf.format(localDate) +".txt";

        BufferedWriter br = new BufferedWriter(new FileWriter(
                new File(pathToReport)));
        //  main/reporting/generatedReports/hammer.txt
        br.write(reportBuffer.toString());
        br.flush();

        br.close();

        return pathToReport;
    }

    public static StringBuffer createReportStringBuffer() throws IOException, SQLException {

        StringBuffer ReportString = new StringBuffer();

        ArrayList<Object> products = selectAllProductnames();

        ArrayList<Object> prices = selectAllProductPrices();

        ArrayList<Object> totalOrds = selectAllTotalOrders();

        ArrayList<Object> remOrds = selectAllRemainingOrders();

        String doubleSep = "===============================================\n";

        String singleSep = "-----------------------------------------------\n";

        String flatSep = "_______________________________________________\n";


        for (int i = 0; i < products.size(); i++) {
            ReportString.append(doubleSep);

            ReportString.append("Product:                     " + products.get(i) + "\n");

            ReportString.append("Price:                       " + prices.get(i) + "\n");
            ReportString.append(doubleSep);
            ReportString.append("\n");

            ReportString.append("Amount sold:                 " + (Integer.valueOf(totalOrds.get(i).toString()) - Integer.valueOf(remOrds.get(i).toString())) + "\n");
            ReportString.append("\n");

            ReportString.append("Stock remaining:             " + remOrds.get(i));
            ReportString.append("\n");

            ReportString.append(singleSep);

            ReportString.append("Current Revenue:             " + Double.valueOf(prices.get(i).toString()) * (Integer.valueOf(totalOrds.get(i).toString()) - Integer.valueOf(remOrds.get(i).toString())) + "\n");
            ReportString.append(singleSep);
            ReportString.append("\n");
            ReportString.append("\n");
            ReportString.append("Maximum Revenue:             " + Double.valueOf(prices.get(i).toString()) * (Integer.valueOf(totalOrds.get(i).toString())) + "\n");
            ReportString.append("\n");
            ReportString.append("\n");
            ReportString.append(singleSep);
            ReportString.append("\n");
            ReportString.append("Stagnant Revenue:            " + (Double.valueOf(prices.get(i).toString()) * (Integer.valueOf(totalOrds.get(i).toString())) - (Double.valueOf(prices.get(i).toString()) * (Integer.valueOf(totalOrds.get(i).toString()) - Integer.valueOf(remOrds.get(i).toString())))) + "\n");
            //  System.out.println();
            ReportString.append(flatSep);
            ReportString.append("\n");
            ReportString.append("\n");


        }
        return ReportString;
    }


    public static void main(String[] args) throws IOException, SQLException, PrintException {

    	StringBuffer output = createReportStringBuffer();
    	System.out.println(output);
      // writeToFile();
    }

}
