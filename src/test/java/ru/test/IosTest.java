package ru.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class IosTest {

    @Test
    public void shouldGenerateNumber() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions()
                .setUdid("6E168440-7923-4EDC-9BB9-54582A8CA9CA")
                .setApp("/Users/nataliya/Desktop/ios-allure-example.app");

        IOSDriver driver = new IOSDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );

        try {
            driver.findElement(AppiumBy.accessibilityId("generate")).click();
            int number = Integer.parseInt(driver.findElement(AppiumBy.accessibilityId("number")).getText());
            assert(number > 0);
            assert(number < 7);
        } finally {
            driver.quit();
        }
    }
}
