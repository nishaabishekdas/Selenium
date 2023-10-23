package com.SeleniumOauth2.Oauth2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SeleniumOauth2.Oauth2.Base.TestBase;

public class MyAppBasicInformation extends TestBase{
	public MyAppBasicInformation() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div[class='sc-5dfcc177-0 elrMXL']>div:first-of-type>div>span")
	private WebElement clientIdTxtBx;
	
	@FindBy(css = "div[class='sc-52d7f8d1-1 gzRjqv'] button")
	private WebElement viewSecretKeyLink;
	
	@FindBy(css = "div[class='sc-5dfcc177-0 elrMXL']>div:nth-of-type(3)>div>span")
	private WebElement clientSecretKeyTxtBx;
	
	@FindBy(css = "div[class='sc-b3983c5c-0 fATKDr']>div:nth-of-type(5)>div>div>div:nth-of-type(4) ul li")
	private WebElement redirectUriTxtBx;
	
	public String getClientID() {
		WebElement clientIdRetreived=wait.until(ExpectedConditions.elementToBeClickable(clientIdTxtBx));
		String clientId=clientIdRetreived.getText();
		return clientId;
	}
	
	public String getClientSecretKey() {
		WebElement ClientSecretKeyRetrieved=wait.until(ExpectedConditions.elementToBeClickable(clientSecretKeyTxtBx));
		String ClientSecretKey=ClientSecretKeyRetrieved.getText();
		return ClientSecretKey;
	}
	
	public String getRedirectUri() {
		WebElement redirectUriRetrieved=wait.until(ExpectedConditions.elementToBeClickable(redirectUriTxtBx));
		String redirectUri=redirectUriRetrieved.getText();
		return redirectUri;
	}
	
	public void clickOnViewClientSecretLink() {
		wait.until(ExpectedConditions.visibilityOf(viewSecretKeyLink)).click();
	}
}
