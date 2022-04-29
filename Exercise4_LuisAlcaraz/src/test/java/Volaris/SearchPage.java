package Volaris;

import org.openqa.selenium.JavascriptExecutor;
import Base.ClsWebElements;

public class SearchPage extends ClsWebElements {
	
	JavascriptExecutor js = (JavascriptExecutor) objDriver;
	
	//Search page Xpaths
	
	String originSearchBtn = "//a[@class = 'btnSearch radius-6']";
	String originInput = "//input [@id = 'fnameOrigin']";
	String originTxt = "Guadalajara";
	String originOpt = "//div[contains(text(),'Guadalajara')]";
	String destinationInput = "//input [@id = 'fnameDestination']";
	String destinationTxt = "Cancún";
	String destinationOpt = "//div[contains(text(),'Cancún')]";
	String monthSelect = "//div[text() =' abril ']//following-sibling::select";
	String monthOpt = "octubre";
	String outBoundFlightDay = "//td[@class = 'weekend datecell-20221029 customfare available']";
	String returnFlightDay = "//td[@class = 'datecell-20221104 returnVisible returnCustomfare available']";
	String doneBtn = "//button[@class = 'btn-calendar d-none d-md-block mat-flat-button mat-button-base mat-secondary']";
	String searchFlight = "//button[@class = 'btn btn-large col-12 search-btn mat-flat-button mat-button-base mat-primary']";
	
	/**
	 * Fill the Origin field for the flight
	 * 
	 */
	public void fillOrigin ()
	{
		WaitForLoad();
		WaitForElementClickable(originSearchBtn);
		Click(originSearchBtn);
		WaitForElementClickable(originInput);
		SendKeys(originInput,originTxt);
		WaitForElementClickable(originOpt);
		Click(originOpt);
	}
	
	/**
	 * Fill the destination field for the flight
	 * 
	 */
	public void fillDestination ()
	{
		WaitForLoad();
		WaitForElementClickable(destinationInput);
		SendKeys(destinationInput,destinationTxt);
		WaitForLoad();
		Click(destinationOpt);
	}
	
	/**
	 * Select dates within the requirements
	 * 
	 */
	public void selectDates () throws InterruptedException
	{
		WaitForLoad();
		deployableList(monthSelect,monthOpt);
		WaitForElementClickable(outBoundFlightDay);
		Click(outBoundFlightDay);
		WaitForLoad();
		WaitForElementClickable(returnFlightDay);
		Click(returnFlightDay);
	}
	
	/**
	 * Finish search and go to the flight lookup
	 * 
	 */
	public void finishSearch() throws InterruptedException
	{
		Thread.sleep(2500);
		Click(doneBtn);
		WaitForLoad();
		Click(searchFlight);
	}
}
