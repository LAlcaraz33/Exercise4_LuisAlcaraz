package Volaris;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.ClsWebElements;

public class FlightSearchPage extends ClsWebElements{
	
	JavascriptExecutor js = (JavascriptExecutor) objDriver;	
	
	//Flight Search Xpaths
	
		String relevantPrice = "//select[@aria-label = 'Ordenado por:']";
		String relevantPriceOpt = "Precio (más barato)";
		String outBoundFlightPrice = "(//div [@class = 'col fareRegular ng-star-inserted']//following-sibling::span[@class = 'price ng-star-inserted'])[position()=1]";
		String selectOutBoundFlight = "//div[@class = 'fareTypes fareTypeRegular']//following-sibling::mat-card[@class = 'basic mat-card ng-star-inserted']";
		String returnFlightPrice = "(//div[@class = 'col fareRegular ng-star-inserted'])[1]";
		String selectReturnFlight = "//div[@class = 'fareTypes fareTypeRegular']//following-sibling::mat-card[@class = 'basic mat-card ng-star-inserted']";
		String closeDialog = "//a[@class = 'closeDialog']";
		String addTUA = "//div[@class = 'mat-checkbox-inner-container']";
		String finalPrice = "//div[@class = 'item GrandTotal grand-total-pulse-animation']//following-sibling::div[not(contains(@class,'grand-total-price-msg')) and not(contains(@class ,'clearfix'))]";
		int budgetFix = 1500;
		
		public void filterResults () throws InterruptedException
		{
			WaitForLoad();
			deployableList(relevantPrice,relevantPriceOpt);
		}
		
		
		public void selectOutBoundFlight () throws InterruptedException
		{
			WaitForLoad();
			js.executeScript("window.scrollBy(0,200)","");
			WaitForElementClickable(outBoundFlightPrice);
			Click(outBoundFlightPrice);
			js.executeScript("window.scrollBy(0,100)","");
			WaitForElementClickable(selectOutBoundFlight);
			Click(selectOutBoundFlight);
			Thread.sleep(2500);
		}
		
		
		public void selectreturnFlight ()
		{
			WaitForLoad();
			WaitForElementClickable(returnFlightPrice);
			Click(returnFlightPrice);
			WaitForElementClickable(selectReturnFlight);
			Click(selectReturnFlight);
			WaitForLoad();
			WaitForElementClickable(closeDialog);
			Click(closeDialog);
		}
		
		public void finishSearch () throws InterruptedException
		{
			WaitForLoad();
			js.executeScript("window.scrollBy(0,2500)","");
			Thread.sleep(1500);
			WaitForElementClickable(addTUA);
			Click(addTUA);
		}
		
		public void comparePrice ()
		{
			WaitForElement(finalPrice);
			WebElement objPrice = getWebElement(finalPrice);
			String vacPrice = objPrice.getAttribute("innerText");
			getInt(vacPrice,budgetFix);
		}
}
