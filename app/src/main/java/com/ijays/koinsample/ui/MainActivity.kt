package com.ijays.koinsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ijays.koinsample.App
import com.ijays.koinsample.R
import com.ijays.koinsample.navigator.AppNavigator
import com.ijays.koinsample.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
