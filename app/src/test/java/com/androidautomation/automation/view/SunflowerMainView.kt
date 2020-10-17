package com.androidautomation.automation.view

import com.androidautomation.LocatorsUtil
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class SunflowerMainView(private val driver: AndroidDriver<MobileElement>) {

    init { PageFactory.initElements(AppiumFieldDecorator(driver), this) }

    //    elems
    private val myGardenBtn = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"My garden\"]/android.widget.TextView\n"

    private val plantListBtn = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Plant list\"]/android.widget.TextView\n"

    private val sunflowerHdr = "//android.widget.FrameLayout[@content-desc=\"Sunflower\"]/android.view.ViewGroup/android.widget.TextView\n"

    //    properties
    fun getSunflowerHdr() :String = LocatorsUtil(driver).visibleXPath(sunflowerHdr).text

    fun getMyGardenSelectedStatus() :String = LocatorsUtil(driver).visibleXPath(myGardenBtn).getAttribute("selected")

    //    actions
    fun tapPlantList() = LocatorsUtil(driver).clickableElemXPath(plantListBtn).click()

    fun tapMyGarden() = LocatorsUtil(driver).clickableElemXPath(myGardenBtn).click()
}