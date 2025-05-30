package StepDeifnition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class AutomationStepDef {

	
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void beforeTest() {
		//ChromeDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ejazh\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	}
	@Test
	public void isPageDisplayed() throws InterruptedException {
		objects.AutomationDemom demo = PageFactory.initElements(driver, objects.AutomationDemom.class);
		demo.verifyPageDisplayed("Orange HRM Page");
	}
	
	@Test(dependsOnMethods= {"isPageDisplayed"})
	public void loginFields() {
		objects.AutomationDemom demo = PageFactory.initElements(driver, objects.AutomationDemom.class);
		demo.enterDetails("Username", "Admin");
		demo.enterDetails("Password", "admin123");
		demo.performAction("Login");
		//demo.performAction("Hamburger");
		demo.performAction("PIM");
		//demo.performAction("add Employee");
	//	demo.addEmployee("Photo Select-Natureimage : First Name-POPOP : Middle Name-LOLOL : Last Name-HAHA : Employee Id-1235 : username-HEHEHE :  Password-ABc123456 : confirm password-ABc123456");
		//demo.performAction("Save");
	
	//	demo.performAction("PIM");
		//demo.performAction("Employee List");
	//	demo.performAction("Refresh");
		//demo.performAction("add Employee");
	//	demo.addEmployee("Photo Select-Natureimage : First Name-abc : Middle Name-XYZ : Last Name-jhjhj : Employee Id-8457 : username-arglstrgu :  Password-ABc123456 : confirm password-ABc123456");
		//demo.performAction("Save");
		//demo.performAction("add Employee");
	//	demo.performAction("Refresh");
		//demo.addEmployee("Photo Select-Natureimage : First Name-cbd : Middle Name-zyx : Last Name- MNMN : Employee Id-845p : username-argls98 :  Password-ABc123456 : confirm password-ABc123456");
		//demo.performAction("Save");
		demo.verifyEmployeeName("POPOP LOLOL - HAHA : ABC CBD - MNO ");
		demo.performAction("Logout");
	}
	@AfterTest
	public void teatDown() {
		driver.close();
		driver.quit();
		
	} 
}
