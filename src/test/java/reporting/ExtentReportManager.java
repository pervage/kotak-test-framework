package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.qa.framework.utilities.CommonUtils;

public class ExtentReportManager {
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        CommonUtils.setEnv("qa");
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(CommonUtils.getFolderPath("/test-output/")+"test-report.html");
        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", CommonUtils.getEnv());
        extent.setSystemInfo("User Name", "Pervage Alam");
        spark.config().setDocumentTitle("Kotak Automation Report");
        spark.config().setReportName("Commercial Credit Card Execution");
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);
    }

    static ExtentReports getInstance() {
        if (extent == null) {
            setExtent();
        }
        return extent;
    }
    public static void endReport() {
        extent.flush();
    }
}
