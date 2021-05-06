package Pages.Mobile;

import driverFactory.Mobile.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotVisibleException;

import java.util.List;

public class CommonPageAction extends DriverFactory {
    @AndroidFindBy(id = "android:id/title")
    private AndroidElement title;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> allTextFromTextView;

    @AndroidFindBy(className = "android.view.View")
    private List<AndroidElement> allTextListFromView;

    @AndroidFindBy(id = "android:id/text1")
    protected List<AndroidElement> selectListPopup;

    public CommonPageAction(AndroidDriver driver) {
        super(driver);
    }

    public void openTestApp(){

    }

    public String getTitle() {
        if(isElementAvailable(title,10))
            return title.getText();
        else {
            throw new ElementNotVisibleException("Title is not present on page");
        }
    }

    public boolean isTextPresentInTextView(String text,int wait){
       return isTextPresentFromList(allTextFromTextView,text,wait) || isTextPresentFromList(allTextListFromView,text,wait);
    }


}
