package com.ws.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class PasswordRecoverPage extends DriverScript {
	
	//***************Page Elements***********//
	
	@FindBy(xpath = "//h1[text()='Password recovery']")WebElement passwordRecoveryText;
	@FindBy(id = "Email")WebElement recoveryEmailTextbox;
	@FindBy(name = "send-email")WebElement Recoverbutton;
	@FindBy(xpath = "//span[@for='Email']")WebElement wrongEmailMsg;
	@FindBy(xpath = "//div[@class='result']")WebElement emailInstructionsSentMsg;
	
	
	//*****************************Page Initialization***********************************//
	public PasswordRecoverPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//*********************************Page Actions/Methods***********************//
	
	public String getpasswordRecoveryText()
	{
		return passwordRecoveryText.getText();
	}
	
	public void enterUserEmail(String email)
	{
		recoveryEmailTextbox.clear();
		recoveryEmailTextbox.sendKeys(email);
	}
	
	public void clickRecoverbutton()
	{
		Recoverbutton.click();
	}
	
	public String getWrongEmailMsg()
	{
		return wrongEmailMsg.getText();
	}
	
	public String getEmailSentMsg()
	{
		return emailInstructionsSentMsg.getText();
	}
	
	
	
}


