package pact.selenium.chapter3_9.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ripon on 11/19/2015.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.ca/";
        driver.get(baseURL + "?gfe_rd=cr&dcr=0&ei=0wGvWZe4E5L-8Ae7lpDAAQ&gws_rd=ssl");
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("Google - Selenium")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public GoogleSearchPage goToSearchPage(){
        driver.findElement(By.id("lst-ib")).sendKeys("Mastering Selenium Testing Tools");
        driver.findElement(By.name("btnK")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new GoogleSearchPage(driver);
    }
}