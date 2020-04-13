package com.report;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = "D:\\Reports";
            System.out.println(workingDir + "\\ExtentReports\\ExtentReportResults.html");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
            
           
           /* if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
            }*/
        }
        return extent;
    }

}
