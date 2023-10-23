package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContext;

public class Hooks {
	public TestContext testContext;
	Properties prop = new Properties();
	FileInputStream configFile;

	public Hooks(TestContext testContext) {
		super();
		this.testContext = testContext;
	}


	@Before
	public void setUp() {
		System.out.println("Before each Scenario");
	}

	@After
	public void tearDown() {
		System.out.println("After Each scenario");
	}

	// Conditional Hooks
	@Before("@AuthorizationCodeAPI")
	public void callMethodBeforeAuthorizationCodeAPI() {
		System.out.println("This executes before the authorizationCodeAPI scenario");
		readPropertyFile();		
	}

	public void readPropertyFile() {

		try {
			configFile = new FileInputStream(
					"C:\\Users\\nishm\\eclipse-workspace\\LearnCucumberFramework\\src\\main\\java\\APIConfigFile.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// context.setUrl(prop.getProperty("https://api.spotify.com"));
		testContext.setClientId(prop.getProperty("Client_Id"));
		testContext.setSecretKey(prop.getProperty("Secret_Key"));
		testContext.setredirectUri(prop.getProperty("Redirect_URI"));
		testContext.setplaylistId(prop.getProperty("playlist_Id"));
	}
}
