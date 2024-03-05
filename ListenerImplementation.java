package CommonUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript execution is started");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript execution is passed");
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript execution is passed", true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript execution is failed");
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is failed"+message, true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript execution is skipped");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is skipped", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("To start the execution");
		//Reporter.log("To start the execution", true);
		
		//Use ExtentSparkReporter class just to configure extent report
		JavaUtil jutil = new JavaUtil();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("Vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Organization");
		
		//Use ExtentReports class to generate extent report
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("ChromeVersion", "121");
		report.setSystemInfo("Author", "Bhagyashree Nimbalkar");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("To finish the execution");
		//Reporter.log("To finish the execution", true);
		report.flush();
		
		
		
	}

}
