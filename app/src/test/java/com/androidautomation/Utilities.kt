package com.androidautomation

import com.google.common.collect.ImmutableMap
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import org.openqa.selenium.logging.LogEntry

class Utilities {

    fun AndroidDriver<MobileElement>.press(key: AndroidKey) = pressKey((KeyEvent(key)))

    fun AndroidDriver<MobileElement>.pressHome() = press(AndroidKey.HOME)

    fun AndroidDriver<MobileElement>.pressBack() = press(AndroidKey.BACK)

    fun AndroidDriver<MobileElement>.launchIntent(intent:String) = executeScript("mobile:shell", ImmutableMap.of(
        "command", "am",
        "args", listOf("start", "-a", intent)
    ))

    fun AndroidDriver<MobileElement>.airplaneMode(enable: Boolean) {
        launchIntent("android.settings.AIRPLANE_MODE_SETTINGS")
        with(findElementById("android:id/switch_widget")) {
            if(isChecked != enable) {
                click()
                Thread.sleep(500)
            }
        }
        pressBack()
    }

    fun AndroidDriver<MobileElement>.wifi(enable: Boolean) {
        launchIntent("android.settings.AIRPLANE_MODE_SETTINGS")
        with(findElementById("com.android.settings:id/switch_widget")) {
            if(isChecked != enable) {
                click()
                Thread.sleep(500)
            }
        }
        pressBack()
    }

    val MobileElement.isChecked
        get() = this.getAttribute("checked")!!.toBoolean()

    val allLogs = mutableListOf<LogEntry>()

    fun AndroidDriver<MobileElement>.getAllLogs() = allLogs.apply { addAll(manage().logs().get("logcat")) }

    fun AndroidDriver<MobileElement>.lastNotification(content: String = "") = this.getNotifications(content).last()

    fun AndroidDriver<MobileElement>.getNotifications(content: String = "") = this.getAllLogs()
        .filter { it.message.contains("V Notification: ") && (content.isBlank() || it.message.contains(content)) }.map(
            Utilities::Notification
        )

    data class Notification(val log: LogEntry) {
        val message: String = log.message.substringAfter("V Notification").substringAfter(": ")
        val type: String = log.message.substringAfter("V Notification").substringBefore(": ")
    }

    fun AndroidDriver<MobileElement>.waitForActivity(activity: String, timeout: Int = 30) {
        for (i in 1..timeout) {
            if(this.currentActivity() == activity) return
            Thread.sleep(1000)
        }
        throw Exception("waited for $activity and timed out")
    }

    fun AndroidDriver<MobileElement>.appBarNavigateUp() = findElementByAccessibilityId("Navigate up")?.click()

    fun AndroidDriver<MobileElement>.getActivity() = this.currentPackage + this.currentActivity()
}