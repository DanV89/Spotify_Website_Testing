
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Search {

	WebDriver driver = new FirefoxDriver();
		
	public void Log()throws InterruptedException{
		JavascriptExecutor sdown = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.spotify.com");
		Thread.sleep(2000);
			
		try{
				
			driver.findElement(By.xpath("//span[@class='user-text navbar-user-text']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("login-username")).click();
			driver.findElement(By.id("login-username")).sendKeys("DanVillette");
			driver.findElement(By.id("login-password")).click();
			driver.findElement(By.id("login-password")).sendKeys("dpassword1");				
			driver.findElement(By.id("login-password")).sendKeys(Keys.RETURN);
			}
		catch(Exception e){
				System.out.println("Already logged in");
			}
				
		Thread.sleep(5000);
		sdown.executeScript("scroll(0, 250);"); //scroll down, change to -250 to scroll up
			
	}
		
	public void edit()throws InterruptedException{
		driver.findElement(By.cssSelector(".nav-inverse > li:nth-child(3) > a:nth-child(1)")).click();
		Thread.sleep(3000);
			
		WebElement gender = driver.findElement(By.id("profile_gender"));
		String sgender = gender.getAttribute("value");
		//System.out.println(sgender);
			
		//Select gender
		Scanner selection = new Scanner(System.in);
		System.out.println("What is your gender: ");
		String yselection  = selection.next();
		String yselection_2 = yselection.toLowerCase();
			
		//Select birth month
		Scanner b_month = new Scanner(System.in);
		System.out.println("Enter your birth month: ");
		String b_month1 = b_month.next();
		String b_month2 = String.format("#profile_birthdate_month > option:nth-child(%s)",b_month1);
			
		//Select birth day
		Scanner b_day = new Scanner(System.in);
		System.out.println("Enter the two digit day of your birth: ");
		String b_day1 = b_day.next();
		String b_day2 = String.format("#profile_birthdate_day > option:nth-child(%s)",b_day1);
			
	//----------------------------------------------------------------------------------------------------------------------------------------
		//Select birth year
		WebElement your_year = driver.findElement(By.cssSelector("#profile_birthdate_year > option:nth-child(1)"));
		String your_year1 = your_year.getAttribute("value");
		//System.out.println(your_year1);
		WebElement your_year2 = driver.findElement(By.cssSelector("#profile_birthdate_year > option:nth-child(18)"));
		String your_year3 = your_year2.getAttribute("value");
		//System.out.println(your_year3);
			
		String key = new String();
		Scanner b_year = new Scanner(System.in); //scanner object to receive input
		System.out.println("Enter your four digit birth year: ");
		String b_year1 = b_year.next(); // stores value of scanner object
				
		int b_year2 = Integer.parseInt(your_year1); //year included in the first element of the birth year list
		int b_year3 = Integer.parseInt(your_year3); ////year included in the 18th element of the birth year list
			
		Map<String, String> map = new HashMap<String, String>(); //create a map (key, value)
		int[] a = new int[101]; // For dates ranging in element 18 to element 100
		int[] c = new int[18]; //For dates ranging from element 1 to element 17
		for(int y=1; y<18; y++) //elements 1 to 17
		{
			c[y] = y;
			String d = Integer.toString(c[y]);
			String s_year2 = Integer.toString(b_year2);
			map.put(s_year2, d);
			if (map.containsKey(b_year1)) //searches for the key value which is the birth year entered
				{
				 key = map.get(b_year1); // gets the value for the birth year entered
				}
			else
			 {
				 key = null;;
			 }
			b_year2--;
		}
		for(int i=18; i<101; i++) // elements 18 to 100
		{
			a[i] = i; 
			String b = Integer.toString(a[i]); //convert integer value (i) to string value
			String s_year1 = Integer.toString(b_year3);
			map.put(s_year1, b); //
			if (map.containsKey(b_year1)) //searches for the key value which is the birth year entered
				{
				 key = map.get(b_year1); // gets the value for the birth year entered
				}
				else
				{
				 key = null;;
				}
				b_year3--; // subtracts one from the newest year, in total 100 will be subtracted from the newest year
				//System.out.print(a[i]+"\n");
				//System.out.print(b+"\n");
				//System.out.print(map+"\n);
				 
				//years.edit(key);
					
		}
		//System.out.print(key + "\n");
		String b_year4 = String.format("#profile_birthdate_year > option:nth-child(%s)",key);
		//System.out.println(b_year4);
		b_year.close();
			
		driver.findElement(By.cssSelector("#profile_birthdate_year")).click();
		driver.findElement(By.cssSelector(b_year4)).click();
			
			
	//----------------------------------------------------------------------------------------------------------------------------------------
					
		try{
			driver.findElement(By.id("profile_postalCode")).click();
			driver.findElement(By.id("profile_postalCode")).sendKeys("30080");
				
			if(sgender.contains(yselection_2))
			{
				System.out.println("");
			}
			else{
				driver.findElement(By.id("profile_gender")).click();
				driver.findElement(By.cssSelector("#profile_gender > option:nth-child(2)")).click();
			}
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(b_month2)).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(b_day2)).click();
			Thread.sleep(2000);
			driver.findElement(By.id("profile_mobile_number")).click();
			driver.findElement(By.id("profile_mobile_number")).sendKeys("678-200-7998");
			Thread.sleep(2000);
			driver.findElement(By.id("profile_mobile_brand")).click();
			driver.findElement(By.cssSelector("#profile_mobile_brand > option:nth-child(2)")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("profile_mobile_provider")).click();
			driver.findElement(By.cssSelector("#profile_mobile_provider > option:nth-child(5)")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#profile_send > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)")).click();
			//driver.findElement(By.id("profile_save_profile")).click();
		}
		catch (Exception e)
		{
			System.out.println("Profile is already set up");
		}
			
		selection.close();
		b_month.close();
		b_day.close();
			
		
	}
}
		

	
	

