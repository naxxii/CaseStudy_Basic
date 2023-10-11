package ObjectsAutoPanda;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AutoPandaContactsPageObjects {
	WebDriver driver;
	
	public AutoPandaContactsPageObjects(WebDriver drvr) {
		this.driver =drvr;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		//PageFactory.initElements(driver, this);
	}
	@FindBy(id="menu-item-10") public WebElement ContactsLink;
	@FindBy(xpath="//*[@name='g3-name']") public WebElement NameField;
	@FindBy(xpath="//*[@name='g3-email']") public WebElement EmailField;
	@FindBy(xpath="//*[@name='g3-message']") public WebElement CommentField;
	@FindBy(xpath="//*[contains(text(),'Contact Me')]") public WebElement ContactMeButton;
	@FindBy(xpath="//*[@id='contact-form-success-header']") public WebElement MessageText;
	
	
	public void SelectContactsLinkMethod() {
		ContactsLink.click();
	}
	public void NameFieldTextMethod(String EnterName) {
		NameField.sendKeys(EnterName);
	}
	public void EmailFieldTextMethod(String EnterEmail) {
		EmailField.sendKeys(EnterEmail);
	}
	public void CommentfieldTextMethod(String CommentText) {
		CommentField.sendKeys(CommentText);
	}
	public void ContactMeButtonMethod() {
		ContactMeButton.click(); 
	}
	public WebElement MessageTextMethod() {		
		return MessageText;
	}

}
