package ru.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAndroidTest {

    static AndroidDriver driver;

    static UiAutomator2Options options;

    @BeforeAll
    static void setUp() {
        options = new UiAutomator2Options()
                .setDeviceName("Pixel 6 API 29")
                .setApp("/Users/nataliya/Desktop/app-debug.apk");
    }

    @BeforeEach
    void startDriver() throws MalformedURLException {
        driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://127.0.0.1:4723"), options
        );
    }

    @Test
    public void shouldIncrementNumber() {
        try {
            driver.findElement(By.id("increment")).click();
            assert(driver.findElement(By.id("counter")).getText().equals("Count: 1"));
        } finally {
            driver.quit();
        }
    }

    @Test
    public void shouldDecrementNumber() {
        try {
            driver.findElement(By.id("decrement")).click();
            assert(driver.findElement(By.id("counter")).getText().equals("Count: -1"));
        } finally {
            driver.quit();
        }
    }

    @Test
    public void shouldClearNumber() {
        try {
            driver.findElement(By.id("clear")).click();
            assert(driver.findElement(By.id("counter")).getText().equals("Count: 0"));
        } finally {
            driver.quit();
        }
    }

}
