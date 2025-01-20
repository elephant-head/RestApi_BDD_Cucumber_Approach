package restAssuredTests;

import javax.swing.text.html.HTMLDocument.HTMLReader;

import org.testng.reporters.HtmlHelper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
    
    // Declare static objects for ExtentReports and ExtentTest
    public static ExtentReports extent;
    public static ExtentTest test;
    private static ExtentReporter htmlReporter;  // Corrected the type to ExtentHtmlReporter

    // Method to initialize and return the ExtentReports object
    public static ExtentReports getExtentReports(ExtentObserver HTMLReader) {
        
        // Only create a new ExtentReports object if it doesn't exist
        if (extent == null) {
            // Create an instance of ExtentHtmlReporter and define the location of the report
            htmlReporter = new ExtentSparkReporter("test-output/Extent_Emailable-Report.html");

            // Configure the appearance of the report
            ((ExtentSparkReporter) htmlReporter).config().setTheme(Theme.STANDARD);  // Choose between STANDARD or DARK theme
            ((ExtentSparkReporter) htmlReporter).config().setDocumentTitle("Test Automation Report");  // Title for the report
            ((ExtentSparkReporter) htmlReporter).config().setReportName("Execution Results");  // Report name that will appear in the header
            
            // Create a new ExtentReports object and attach the HTML reporter
            extent = new ExtentReports();
            extent.attachReporter(HTMLReader); // Attach the HTML reporter to ExtentReports
            
            // Add system information to the report (e.g., OS, Java version, etc.)
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Tester", "Your Name");
        }

        // Return the initialized ExtentReports object
        return extent;
    }
}