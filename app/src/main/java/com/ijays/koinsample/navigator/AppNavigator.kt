package com.ijays.koinsample.navigator

/**
 * Created by ijays on 2020/7/14.
 */
enum class Screens {
    BUTTONS,
    LOGS
}

interface AppNavigator {
    // Navigate to a given screen
    fun navigateTo(screen: Screens)
}