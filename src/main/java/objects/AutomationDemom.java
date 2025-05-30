package objects;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


	
	
public class AutomationDemom {
	
	static WebDriver driver = null;
	@FindBy(how=How.XPATH,using="//div/img[@alt='company-branding']")
	@CacheLookup
	private WebElement orangeHRM;
	
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='Username']")
	@CacheLookup
	private WebElement userNameField;
	
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='Password']")
	@CacheLookup
	private WebElement passwordField;


	@FindBy(how=How.XPATH,using="//div/button[text()=' Login ']")
	@CacheLookup
	private WebElement loginBtn;
	
	@FindBy(how=How.XPATH,using="//header/descendant::i[1]")
	@CacheLookup
	private WebElement humburgerIcon;
	
	@FindBy(how=How.XPATH,using="//div[@class='oxd-sidepanel-body']/descendant::ul/li[2]")
	@CacheLookup
	private WebElement pimSection;
	
	@FindBy(how=How.XPATH,using="//li/a[text()='Add Employee']")
	@CacheLookup
	private WebElement addBtn;
	
	
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='First Name']")
	@CacheLookup
	private WebElement firstNameField;
	
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='Middle Name']")
	@CacheLookup
	private WebElement middleNameField;
	
	@FindBy(how=How.XPATH,using="//div/input[@placeholder='Last Name']")
	@CacheLookup
	private WebElement lastNameField;
	
	@FindBy(how=How.XPATH,using="//div/label[text()='Employee Id']/following::input[1]")
	@CacheLookup
	private WebElement employeedIDField;

	
	@FindBy(how=How.XPATH,using="//div/label/input[@type='checkbox']")
	@CacheLookup
	private WebElement credentialCheckbox;
	
	@FindBy(how=How.XPATH,using="//div/label[text()='Username']/following::input[1]")
	@CacheLookup
	private WebElement userNameCredentialsField;
	
	@FindBy(how=How.XPATH,using="//div/label[text()='Password']/following::input[1]")
	@CacheLookup
	private WebElement passwordCredentialsField;

	
	@FindBy(how=How.XPATH,using="//div/label[text()='Confirm Password']/following::input[1]")
	@CacheLookup
	private WebElement confirmPasswordCredentialsField;
	
	@FindBy(how=How.XPATH,using="//div[@class='employee-image-wrapper']/following-sibling::button")
	@CacheLookup
	private WebElement photoSelectBtn;
	
	@FindAll({@FindBy(how=How.XPATH,using="//div/descendant::button[@type='submit']"),
		@FindBy(how=How.XPATH,using="//div/p/following-sibling::button")
	})
	@CacheLookup
	private WebElement saveBtn;
	
	@FindBy(how=How.XPATH,using="//div/label[text()='Employee Name']/following::input[1][@placeholder='Type for hints...']")
	@CacheLookup
	private WebElement employeeNameFilter;

	@FindBy(how=How.XPATH,using="//button[@type='submit' and text()=' Search ']")
	@CacheLookup
	private WebElement searchBtn;
	
	@FindBy(how=How.XPATH,using="//li[@class='oxd-userdropdown']//i")
	@CacheLookup
	private WebElement userProfile;
	
	@FindBy(how=How.XPATH,using="//ul[@class='oxd-dropdown-menu']/li[4]/a[text()='Logout']")
	@CacheLookup
	private WebElement logoutBtn;
	
	public AutomationDemom(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public AutomationDemom performAction(Object...args) {
		
		try {
			String action = args[0].toString().toUpperCase();
			Actions act = new Actions(driver);
			FluentWait wait = new FluentWait(driver);
			switch(action.replace(" ", "")){
			case "LOGIN":
				loginBtn.click();
				System.out.println("Clicked on "+action+" button");
				Thread.sleep(5000);
				break;
			case "HAMBURGER":
				waitsExplicitly(60, humburgerIcon);
				humburgerIcon.click();
				System.out.println("Clicked on "+action+" button");
				break;
			case "PIM":
				act.moveToElement(pimSection).click().build().perform();
				System.out.println("Clicked on "+action+" button");
				waitsExplicitly(30, addBtn);
				break;
			case "CHECKBOX":
				act.moveToElement(credentialCheckbox).click().build().perform();
				System.out.println("Clicked on "+action+" button");
				break;
			case "ADDEMPLOYEE":
				wait.withTimeout(Duration.ofSeconds(200));
				wait.pollingEvery(Duration.ofSeconds(5));
				wait.ignoring(StaleElementReferenceException.class);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Add Employee']")));
				driver.findElement(By.xpath("//li/a[text()='Add Employee']")).click();
				System.out.println("Clicked on "+action+" button");
				break;
			case "EMPLOYEELIST":
				wait.withTimeout(Duration.ofSeconds(200));
				wait.pollingEvery(Duration.ofSeconds(5));
				wait.ignoring(StaleElementReferenceException.class);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Employee List']")));
				driver.findElement(By.xpath("//li/a[text()='Employee List']")).click();
				System.out.println("Clicked on "+action+" button");
				break;
			case "SAVE":
				saveBtn.click();
				System.out.println("Clicked on "+action+" button");
				Thread.sleep(15000);
				break;
			case "REFRESH":
				driver.navigate().refresh();
				break;
			case "LOGOUT":
				userProfile.click();
				waitsExplicitly(30, logoutBtn);
				logoutBtn.click();
				System.out.println("Logged out of the Dashboard");
				break;
				default:
					throw new Exception();
			}
			
		}catch(Exception E){
			System.out.println("Validation couldn't be completed because of following reason "+E);
		}
		
		
		return this;
		
	}
	public AutomationDemom verifyPageDisplayed(Object...args) throws InterruptedException {
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//div/img[@alt='company-branding']")).size()!=0) {
			System.out.println("Logged into "+args[0].toString());
		}
		return this;
	}
	public AutomationDemom enterDetails(Object...args) {
		String field = args[0].toString().toUpperCase().trim();
		String value = args[1].toString();
		try{
			switch(field.replace(" ", "")) {
		
		case "USERNAME":
			userNameField.sendKeys(value.trim());
			System.out.println("Entered value "+value+" in "+field);
			break;
		case "PASSWORD":
			passwordField.sendKeys(value);
			System.out.println("Entered value "+value+" in "+field);
			break;
			default: 
				throw new Exception();
			
		}
		}catch(Exception E) {
			System.out.println("Validation couldn't be completed because of following reason "+E);
		}
		return this;
		}
	public static void waitsExplicitly(int seconds,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public AutomationDemom addEmployee(Object...args) {
		String[] list = ((String) args[0]).split(":");
		//System.out.println(Arrays.toString(list));
		HashMap<String, String> map = new LinkedHashMap();
		Actions act = new Actions(driver);
		for(int i =0;i<list.length;i++) {
			String[] list1 = list[i].split("-");
			map.put(list1[0], list1[1]);		
		}
		FluentWait waitp = new FluentWait(driver);
		Set<String> fields =  map.keySet();
	for(String field : fields) {
		try{
			switch(field.toUpperCase().replace(" ", "")) {
			case "PHOTOSELECT":
				waitp.withTimeout(Duration.ofSeconds(200));
				waitp.pollingEvery(Duration.ofSeconds(5));
				waitp.ignoring(StaleElementReferenceException.class);
				waitp.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='employee-image-wrapper']/following-sibling::button")));
				driver.findElement(By.xpath("//div[@class='employee-image-wrapper']/following-sibling::button")).click();
				Thread.sleep(5000);
				
				Robot robot = new Robot();
				StringSelection selction = new StringSelection("C:\\Users\\ejazh\\OneDrive\\Desktop\\My Files\\"+map.get(field).trim());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selction, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				break;
		case "FIRSTNAME":
			fluentWait(200, 5, "//div/input[@placeholder='First Name']");
			driver.findElement(By.xpath("//div/input[@placeholder='First Name']")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
		case "MIDDLENAME":
			fluentWait(200, 5, "//div/input[@placeholder='Middle Name']");
			driver.findElement(By.xpath("//div/input[@placeholder='Middle Name']")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
		case "LASTNAME":
			fluentWait(200, 5, "//div/input[@placeholder='Last Name']");
			driver.findElement(By.xpath("//div/input[@placeholder='Last Name']")).sendKeys(map.get(field).trim());
			//lastNameField.sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
		case "EMPLOYEEID":
			fluentWait(200, 5, "//div/label[text()='Employee Id']/following::input[1]");
			driver.findElement(By.xpath("//div/label[text()='Employee Id']/following::input[1]")).clear();
			driver.findElement(By.xpath("//div/label[text()='Employee Id']/following::input[1]")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			fluentWait(200,5, "//div/label/input[@type='checkbox']" );
			try {
			
			js.executeScript("arguments[0].click();", credentialCheckbox);
			}catch(Exception E) {
				js.executeScript("arguments[0].click();", credentialCheckbox);
			}
			break;
		case "USERNAME":
			fluentWait(200, 5, "//div/label[text()='Username']/following::input[1]");
			driver.findElement(By.xpath("//div/label[text()='Username']/following::input[1]")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
		case "PASSWORD":
			fluentWait(200, 5, "//div/label[text()='Password']/following::input[1]");
			driver.findElement(By.xpath("//div/label[text()='Password']/following::input[1]")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
		case "CONFIRMPASSWORD":
			fluentWait(200, 5, "//div/label[text()='Confirm Password']/following::input[1]");
			driver.findElement(By.xpath("//div/label[text()='Confirm Password']/following::input[1]")).sendKeys(map.get(field).trim());
			System.out.println("Entered "+map.get(field).trim()+" in "+field);
			break;
			default:
				throw new Exception();
		}
		}catch(Exception E) {
			System.out.println("Validation couldn't be completed because of following reason "+E);
		}
	}
			return this;
		
	}
	public static <T> void fluentWait( int totalSeconds, int pollingSeconds, String xPath){
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(totalSeconds));
		wait.pollingEvery(Duration.ofSeconds(pollingSeconds));
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(""+xPath.trim()+"")));
		
	}
	public AutomationDemom verifyEmployeeName(Object...arg) {
		String[] data = arg[0].toString().split(":");
		try {
			
			HashMap<String, String> names = new LinkedHashMap<String, String>();
			
			for(int i=0;i<data.length;i++) {
				String[] nameList = data[i].split("-");
				names.put(nameList[0], nameList[1]);
			}
			Set<String> firstName = names.keySet();
		//	JavascriptExecutor js = (JavascriptExecutor)driver;
			System.out.println(names+" "+ firstName);
			Actions act = new Actions(driver);
			for(String first :firstName) {
				act.click(employeeNameFilter).perform();
				act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
				act.sendKeys(Keys.DELETE).perform();
				Thread.sleep(3000);
				employeeNameFilter.sendKeys(first.toString().trim());
				driver.findElement(By.xpath("//button[@type='submit' and text()=' Search ']")).click();
				Thread.sleep(3000);
				act.sendKeys(Keys.PAGE_DOWN).build().perform();				
				WebElement firstNameOfEmployee = driver.findElement(By.xpath("//div[text()='"+first.trim()+"']"));
				System.out.println("Not null");
				WebElement lastName = driver.findElement(By.xpath("//div[text()='"+names.get(first).trim()+"']"));
			 assertEquals(firstNameOfEmployee.getText().trim(), first.toString().trim(), "First and Middle Name doesn't match");
			 assertEquals(lastName.getText().trim(), names.get(first).trim() , "First and Middle Name doesn't match");
			 boolean firstAndMiddleName = firstNameOfEmployee.getText().equals(first.toString().trim());
			 boolean lastName1= lastName.getText().equals(names.get(first).trim());
			 if(firstAndMiddleName && lastName1) {
				System.out.println(first.toString()+""+names.get(first)+" Name Verified");
			 }else {
				 System.out.println("Name not Verified");
			 }
			}
			
			
		}catch(Exception E) {
			System.out.println("Validation couldn't be completed because of following reason "+E);
			
		}
		
		return this;
	}
	}


