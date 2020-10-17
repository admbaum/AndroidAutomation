package com.androidautomation

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class BaseTest {

        lateinit var driver: AndroidDriver<MobileElement>
        private val capabilities = DesiredCapabilities().apply {
            setCapability(MobileCapabilityType.APPIUM_VERSION, "1.14.2")
            setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
            setCapability("appPackage", "com.google.samples.apps.sunflower")
            setCapability("appActivity", ".GardenActivity")
            setCapability("automationName", "uiautomator2")
            setCapability("skipDeviceInitialization", true)
            setCapability("noReset", true)
            setCapability("enableMultiWindows", true)
            setCapability("unlockType", "pin")
            setCapability("unlockKey", "0000")
            setCapability("newCommendTimeout", "120")
        }

        @Before
        fun setup() {
            driver = AndroidDriver(URL("http://127.0.0.1:4750/wd/hub"), capabilities)
            driver.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        }

        @After
        fun tearDown() {
            driver.quit()
        }
}