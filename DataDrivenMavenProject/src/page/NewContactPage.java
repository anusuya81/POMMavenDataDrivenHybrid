package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewContactPage {
WebDriver driver;
	
	public NewContactPage(WebDriver ldriver){
		
		this.driver=ldriver;
	}


	@FindBy(how=How.ID,using="account")
	WebElement Fullname;
	
	@FindBy(how=How.ID,using="company")
	WebElement company;
	
	@FindBy(how=How.ID,using="email")
	WebElement email;
	
	@FindBy(how=How.ID,using="phone")
	WebElement phone;
	
	@FindBy(how=How.ID,using="address")
	WebElement address;
	
	@FindBy(how=How.ID,using="city")
	WebElement city;
	
	@FindBy(how=How.ID,using="state")
	WebElement state;
	
	@FindBy(how=How.ID,using="zip")
	WebElement zip;
	
	@FindBy(how=How.ID,using="submit")
	WebElement submit;
	
	
	
	
     public void AddingNewContactInfo(String Fname,String Comp,String Email,String Phone,String Add,String City,String State,String Zip){
		Fullname.sendKeys(Fname);
		company.sendKeys(Comp);
		email.sendKeys(Email);
		phone.sendKeys(Phone);
		address.sendKeys(Add);
		city.sendKeys(City);
		state.sendKeys(State);
		zip.sendKeys(Zip);
		submit.click();
		
	}
	
}
