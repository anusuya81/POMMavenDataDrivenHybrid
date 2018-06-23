package test;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.NewContactPage;
import page.Techfios_homepage;
import page.Techfios_login;
import reader.ReadData;
import util.BrowserFactory;

public class NewContactTest {
ReadData readExcelData = new ReadData();
	
	String Username ;
	String Password;
	String Fullname;
	String Company;
	String email;
	String phone;
	//String phone1;
	String Address;
	String City;
	String State;
	String zip;
	
	public  NewContactTest() throws IOException
	{
		String userdata[][]=readExcelData.getLogInDataFromExcelFile();
		//System.out.println(userdata.length);
		try {
		for(int j=1; j<userdata.length;j++)
		{
			Username=userdata[j][0];
			Password=userdata[j][1];
			Fullname=userdata[j][9];
			Company=userdata[j][10];
			email=userdata[j][11];
			phone=userdata[j][12];
			Address=userdata[j][13];
			City=userdata[j][14];
			State=userdata[j][15];
			zip=userdata[j][16];
		}
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("ArrayIndexOutOfBoundsException e");
		}
	}
	@Test
	public void TechfiosTest() throws IOException{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
		Techfios_login login = PageFactory.initElements(driver, Techfios_login.class);
		login.login_techfios(Username, Password);
		
		Techfios_homepage home = PageFactory.initElements(driver, Techfios_homepage.class);		
		home.Click_CRM();
		
		NewContactPage contact=PageFactory.initElements(driver,NewContactPage.class );
		contact.AddingNewContactInfo(Fullname,Company,email,phone,Address,City,State,zip);
		
		driver.close();
		driver.quit();
	}
	
}
