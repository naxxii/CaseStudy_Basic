package Com.AutomationPanda;


import org.testng.annotations.Test;

import Base.BaseClass;
import ObjectsAutoPanda.AutoPandaContactsPageObjects;

public class ContactsPage extends BaseClass{
	
	
	@Test(priority=1)
	  public void VerifyingHomePageTitle() {
		//Open URL
		driver.get(baseURLAutoPanda);
		//Maximize Screen
		driver.manage().window().maximize();
			//Storing current page Title in to TitleActual
		  	String TitleActual=driver.getTitle();	
		  	//Saving current page title manually in to Title Expected
			String TitleExpected="Want to practice test automation? Try these demo sites! | Automation Panda";
			//Comparing both titles
			if(TitleExpected.equals(TitleActual))
			{
				System.out.println("Title Matched");
			}else 
			{
				System.out.println("Title didn't Match");
			}
	}

	@Test(priority=2)
	public void VerifyingContactsPage() {
		AutoPandaContactsPageObjects ContactsPage= new AutoPandaContactsPageObjects(driver);		
		//selecting Contacts link
		ContactsPage.SelectContactsLinkMethod();
		//Storing current page Title in to ContactActual
		String ContactActual = driver.getTitle();
		//Saving current page title manually in to ContactExpected
		String ContactExpected = "Contact | Automation Panda";
		//Comparing both titles
		if (ContactExpected.equalsIgnoreCase(ContactActual)) {
			System.out.println("Contacts title matched");
		} else {
			System.out.println("Contacts title didn't matched");
		}
		//entering all details
		ContactsPage.NameFieldTextMethod("tester1");
		
		
		ContactsPage.EmailFieldTextMethod("tester1@gmail.com");		
		
		
		ContactsPage.CommentfieldTextMethod("Message entered by Tester1");
		
		//clicking on ContactMe button
		ContactsPage.ContactMeButtonMethod();
		
		//Storing Message sent text in to MessageSentActual
		String MessageSentActual = ContactsPage.MessageTextMethod().getText();
		//Saving current page title manually in to Messagesent text in to MessageSentExpected
		String MessageSentExpected = "Your message has been sent";
		//Comparing both messages
		if (MessageSentExpected.equalsIgnoreCase(MessageSentActual)) {
			System.out.println("Message Sent got matched");
		} else {
			System.out.println("Message Sent didn't matched");
		}
	}

}
