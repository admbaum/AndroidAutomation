package com.androidautomation

import io.appium.java_client.MobileElement
import io.appium.java_client.PerformsTouchActions
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.support.PageFactory

class TouchActionUtil(private val driver: AndroidDriver<MobileElement>) {

    init { PageFactory.initElements(AppiumFieldDecorator(driver), this)}

    class PlatformTouchAction(performsTouchActions: PerformsTouchActions) :
        TouchAction<PlatformTouchAction>(performsTouchActions)

    fun swipeTheScreen() {
        Thread.sleep(2000)
        PlatformTouchAction(driver).press(PointOption.point(1229, 328))
            .moveTo(PointOption.point(1331, 361)).release().perform()
    }
}