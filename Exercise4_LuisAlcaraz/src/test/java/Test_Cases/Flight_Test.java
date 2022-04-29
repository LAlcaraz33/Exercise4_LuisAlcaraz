package Test_Cases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import com.aventstack.extentreports.Status;
import Base.ClsBrowser;
import Base.ClsReport;
import Base.ClsWebElements;
import Volaris.FlightSearchPage;
import Volaris.SearchPage;

public class Flight_Test extends ClsWebElements {

	@Rule 
	public TestName TC_Name = new TestName();
	public String URL = "https://www.volaris.com/";
	public static String reportLocation = "C:\\\\Report\\\\FlightReport.html";
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport(reportLocation);
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "CHROME";
		OpenBrowser();
	} 
	
	
	@Test
	public void TestScenario_3()
	{
		
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("GDL CUN Flight Search");
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, "Navigation to URL.", false);
			SearchPage objSearch = new SearchPage();
			FlightSearchPage objFlight = new FlightSearchPage();
			objSearch.fillOrigin();
			ClsReport.fnLog(Status.PASS, "Origin Data Entered.", false);
			objSearch.fillDestination();
			ClsReport.fnLog(Status.PASS, "Destination Data Entered.", true);
			objSearch.selectDates();
			ClsReport.fnLog(Status.INFO, "Dates Selected.", false);
			objSearch.finishSearch();
			ClsReport.fnLog(Status.PASS, "Flight Lookup Finished.", true);
			objFlight.filterResults();
			ClsReport.fnLog(Status.PASS, "Flight Filter price Applied.", false);
			objFlight.selectOutBoundFlight();
			ClsReport.fnLog(Status.PASS, "Outbound Flight Selected.", false);
			objFlight.selectreturnFlight();
			ClsReport.fnLog(Status.PASS, "Return Flight Selected.", false);
			objFlight.finishSearch();
			ClsReport.fnLog(Status.PASS, "Search Finished.", true);
			objFlight.comparePrice();
			ClsReport.fnLog(Status.PASS, "Report Finished.", true);
			Thread.sleep(3500);
		}
		catch(Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , true);
		}
	}
		
		
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}

}
