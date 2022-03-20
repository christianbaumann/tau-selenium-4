import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots extends BaseTest {

    @BeforeMethod
    public void navigate() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://applitools.com/");
    }

    @Test
    public void takeWebElementScreenshot() throws IOException {
        By nextGenerateionPlatformByXpath = By.cssSelector("#post-8 h1");

        WebElement nextGenerationPlatform = driver.findElement(nextGenerateionPlatformByXpath);

        File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
        File destination = new File("Next Generation Platform.png");
        FileHandler.copy(source, destination);
    }

    @Test
    public void takeWebElementPageSectionScreenshot() throws IOException {
        By applitoolsPageSectionByCssSelector = By.cssSelector("#post-8>header");

        WebElement applitoolsPageSection = driver.findElement(applitoolsPageSectionByCssSelector);

        File source = applitoolsPageSection.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("Applitools Page Section.png"));
    }

    @Test
    public void takeFullPageScreenshot() throws IOException {
        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File
                ("Applitools Full Page Screenshot.png"));
    }
}
