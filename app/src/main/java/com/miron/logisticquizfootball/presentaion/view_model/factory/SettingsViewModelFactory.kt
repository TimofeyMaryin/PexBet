package com.miron.logisticquizfootball.presentaion.view_model.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miron.logisticquizfootball.presentaion.view_model.SettingsViewModel

@Suppress("UNCHECKED_CAST")
class SettingsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsViewModel(context = context) as T
    }
}