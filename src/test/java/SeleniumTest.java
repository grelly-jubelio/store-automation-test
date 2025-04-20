import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    void Setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/grellylondo/Documents/Work/Jubelio/Automation/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://v2-stg.staging.jubelio.store/store/tv0lmailpi8nl/product/unit?status=true");
        System.out.println(driver.getTitle());
    }
}
