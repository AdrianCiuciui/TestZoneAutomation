import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SettingUpTheProjectTest {

    private static final String URL_INITIAL = "https://www.google.com/";
    private static final String URL_EXPECTED = "https://www.google.com/search?q=adrian";
    private static final By ACCEPT_COOKIES = By.xpath("//*[@id=\"L2AGLb\"]");
    private static final By SEARCH_INPUT_FIELD = By.xpath("//*[@class=\"gLFyf\"]");

    @Test ()
    void shortSmokeTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get(URL_INITIAL);
        Thread.sleep(1000);
        driver.findElement(ACCEPT_COOKIES).click();
        Thread.sleep(1000);
        driver.findElement(SEARCH_INPUT_FIELD).sendKeys("adrian" + Keys.RETURN);
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL, is(URL_INITIAL));
        Thread.sleep(1000);
        currentURL = driver.getCurrentUrl();
        assertThat(currentURL, containsString(URL_EXPECTED));
        Thread.sleep(2000);
        driver.close();
    }
}
