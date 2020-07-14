package com.ijays.koinsample.navigator

import androidx.fragment.app.FragmentActivity
import com.ijays.koinsample.R
import com.ijays.koinsample.ui.ButtonsFragment
import com.ijays.koinsample.ui.LogsFragment

/**
 * Created by ijays on 2020/7/14.
 */
class AppNavigatorImpl(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.BUTTONS -> ButtonsFragment()
            Screens.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }

}