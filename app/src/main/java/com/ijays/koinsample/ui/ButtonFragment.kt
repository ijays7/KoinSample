package com.ijays.koinsample.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ijays.koinsample.App
import com.ijays.koinsample.R
import com.ijays.koinsample.data.LoggerLocalDataSource
import com.ijays.koinsample.navigator.AppNavigator
import com.ijays.koinsample.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by ijays on 2020/7/14.
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject lateinit var logger: LoggerLocalDataSource
    @Inject lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    //region Replaced with Hilt
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//        populateFields(context)
//    }
//
//    private fun populateFields(context: Context) {
//        logger = (context.applicationContext as App).serviceLocator.loggerLocalDataSource
//
//        navigator = (context.applicationContext as App).serviceLocator.provideNavigator(activity!!)
//    }
    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}
