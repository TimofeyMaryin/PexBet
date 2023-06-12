package com.miron.logisticquizfootball.presentaion

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.miron.logisticquizfootball.presentaion.navigation.MainNavController
import com.miron.logisticquizfootball.presentaion.ui.theme.LogisticQuizFootballTheme
import com.miron.logisticquizfootball.presentaion.view_model.SettingsViewModel
import com.miron.logisticquizfootball.presentaion.view_model.factory.SettingsViewModelFactory


class MainActivity : ComponentActivity() {
    private val settingsViewModel: SettingsViewModel by viewModels(factoryProducer = { SettingsViewModelFactory(context = applicationContext) })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // settingsViewModel.startMediaPlayer(applicationContext)
        setContent { MainScreen(settingsViewModel = settingsViewModel) }
    }

    override fun onStop() {
        super.onStop()
        settingsViewModel.stopMediaPlayer()
    }

    override fun onStart() {
        super.onStart()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        settingsViewModel.startMediaPlayer(this)
    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }


    @Composable
    private fun MainScreen(settingsViewModel: SettingsViewModel) {
        val navController = rememberNavController()
        LogisticQuizFootballTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MainNavController(navController = navController, settingsViewModel = settingsViewModel)
            }
        }
    }
}


