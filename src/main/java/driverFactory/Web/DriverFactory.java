package driverFactory.Web;



import driverFactory.CommonDriverFactoryMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


public class DriverFactory extends CommonDriverFactoryMethod {
    protected WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    protected boolean isElementAvailable(WebElement element, int timeoutVal) {
        return super.isElementAvailable(element,timeoutVal,driver);
    }

    protected void switchToIframeByWebElement(WebElement element,int timeout){
        isElementAvailable(element,timeout);
        driver.switchTo().frame(element);
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected void selectValueByVisibleText(WebElement selectParentWebElement, String tag, String visibleText, int timeout) {
        isElementAvailable(selectParentWebElement, timeout);
        selectParentWebElement.findElement(By.xpath("//" + tag + "[text()='" + visibleText + "']")).click();
    }

    protected List<WebElement> getValuesByVisibleText(WebElement selectParentWebElement, String tag, String visibleText, int timeout) {
        isElementAvailable(selectParentWebElement, timeout);
        return selectParentWebElement.findElements(By.xpath("//" + tag + "[text()='" + visibleText + "']"));
    }

    public void selectControl(){
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).keyDown(Keys.CONTROL).perform();
    }

    public void deselectControl(){
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
    }

    protected void dragAndDrop(WebElement source, WebElement target,int timeout){
        isElementAvailable(target,timeout);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }

}


