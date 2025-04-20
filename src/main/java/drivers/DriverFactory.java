package drivers;

import config.WebdriverConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    @Value("${device:chrome}")
    private String device;

    @Autowired
    private WebdriverConfig webdriverProvider;

    @Bean
    @Primary
    @ConditionalOnProperty(name = "device", havingValue = "chrome", matchIfMissing = true)
    public ChromeDriver chromeDriver() {
        return webdriverProvider.createChromeDriver();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "device", havingValue = "firefox")
    public FirefoxDriver firefoxDriver() {
        return webdriverProvider.createFirefoxDriver();
    }
}
