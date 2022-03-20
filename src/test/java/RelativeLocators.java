import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testRelativeLocator() {
        WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
        WebElement credentials = driver.findElement(
                with(By.tagName("span")).above(loginPanel)
        );

        System.out.println(credentials.getText());
    }

    @Test
    public void testListOfElements() {
        List<WebElement> allSocialMedia = driver.findElements(with(
                By.tagName("img"))
                .near(By.id("footer")));

        for (WebElement socialMedia : allSocialMedia) {
            System.out.println(socialMedia.getAttribute("alt"));
        }
    }
}
