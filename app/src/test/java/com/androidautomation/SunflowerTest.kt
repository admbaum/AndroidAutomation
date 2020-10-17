package com.androidautomation

import org.junit.Test
import com.androidautomation.automation.view.SunflowerMainView
import org.junit.Assert.assertTrue

class SunflowerTest : BaseTest() {

    @Test
    fun toggleToPlantListAndBack() {
        with(SunflowerMainView(driver)) {
            tapPlantList()
            assertTrue(getMyGardenSelectedStatus() == "false")
        }

    }
}