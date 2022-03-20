import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementPosition extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("https://testautomationu.applitools.com/learningpaths.html");
    }

    @Test
    public void getPositionDimension() {
        By logoTauByXpath = By.xpath("//div[@id='app']//header/a/img");

        WebElement logoTau = driver.findElement(logoTauByXpath);
        Rectangle rectTauLogo = logoTau.getRect();

        System.out.println("x: " + rectTauLogo.getX());
        System.out.println("y: " + rectTauLogo.getY());
        System.out.println("Width: " + rectTauLogo.getWidth());
        System.out.println("Height: " + rectTauLogo.getHeight());
    }
}
