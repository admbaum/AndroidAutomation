package com.androidautomation

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LocatorsUtil(private val driver: AndroidDriver<MobileElement>) {

    fun clickableElementID(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .elementToBeClickable(MobileBy.id(elementName)))

    fun clickableElemXPath(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .elementToBeClickable(MobileBy.xpath(elementName)))

    fun clickableElemAccessibilityID(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .elementToBeClickable(MobileBy.AccessibilityId(elementName)))

    fun visibleID(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .visibilityOfElementLocated(MobileBy.id(elementName)))

    fun visibleXPath(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .visibilityOfElementLocated(MobileBy.xpath(elementName)))

    fun AccessibilityID(elementName: String = "") = WebDriverWait(driver, 60)
        .withMessage("elem wasnt on the screen").until(
            ExpectedConditions
            .visibilityOfElementLocated(MobileBy.AccessibilityId(elementName)))
}