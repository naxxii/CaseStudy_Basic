package ObjectsFlipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class FlipkartObjects {
	WebDriver driver;
	public FlipkartObjects(WebDriver drvr) {
		this.driver =drvr;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		//PageFactory.initElements(driver, this);
	}
	//By lightBoxMethod= By.xpath("//*[@class='_2KpZ6l _2doB4z']");
	
	@FindBy(xpath="//*[@class='_2KpZ6l _2doB4z']") public WebElement lightBox;
	//@FindBy(xpath="//*[@class='_2KpZ6l _2doB4z']") public WebElement CloseBtn;
	@FindBy(xpath="//*[@class='_2xm1JU']") public WebElement flipkartLogo;
	@FindBy(xpath="//*[@name='q']") public WebElement searchText;
	@FindBy(xpath="//*[@class='L0Z3Pu']") public WebElement searchBtn;
	@FindBy(xpath="//*[@class='_4rR01T']") public List<WebElement> searchResults;
	@FindBy(xpath="//*[@class='B_NuCI']") public WebElement OpenedMobile;
	
	public WebElement lightBoxMethod() {
		return lightBox;
	}
	//public WebElement CloseBtn() {
	//	return(CloseBtn);
	//}
	public WebElement flipkartLogoMethod() {
		return(flipkartLogo);
	}
	public void searchTextMethod(String searchKey) {
		searchText.sendKeys(searchKey);
	}
	public WebElement searchBtnMethod() {
		return(searchBtn);
	}
	public List<WebElement> searchResultsMethod() {
		return (List<WebElement>)(searchResults);
	}
	public WebElement OpenedMobileMethod() {
		return(OpenedMobile);
	}
}
