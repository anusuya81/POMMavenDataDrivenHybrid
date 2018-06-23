package test;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.Techfios_homepage;
import page.Techfios_login;
import page.TransNewExpensePage;
import reader.ReadData;
import util.BrowserFactory;

public class TransNewExpenseTest {
ReadData readExcelData = new ReadData();
	
	String Username ;
	String Password;
	String Accountinfo;
	String Description;
	String Amount;
	
	public  TransNewExpenseTest() throws IOException
	{
		String userdata[][]=readExcelData.getLogInDataFromExcelFile();
		for(int j=1; j<userdata.length;j++)
		{
			Username=userdata[j][0];
			Password=userdata[j][1];
			 Accountinfo=userdata[j][17];
			Description=userdata[j][18];
			Amount=userdata[j][19];
		}
	}
	@Test
	public void TechfiosTest() throws IOException{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
		Techfios_login login = PageFactory.initElements(driver, Techfios_login.class);
		login.login_techfios(Username, Password);
		
		Techfios_homepage home = PageFactory.initElements(driver, Techfios_homepage.class);		
		home.Click_Transaction();
		
		TransNewExpensePage expense=PageFactory.initElements(driver, TransNewExpensePage.class);
		expense.AddingNewExpenseInfo( Accountinfo,Description, Amount);
		
		driver.close();
		driver.quit();
	}
}
