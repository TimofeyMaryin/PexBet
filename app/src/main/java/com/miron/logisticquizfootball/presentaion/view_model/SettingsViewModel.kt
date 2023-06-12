package com.miron.logisticquizfootball.presentaion.view_model

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miron.logisticquizfootball.R

class SettingsViewModel(context: Context) : ViewModel() {

    private var audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.second_song)

    var currentMusicIndex by mutableStateOf(1f) // 0..2
    var currentVolumeLevel by mutableStateOf(3) // 0..6
    private val maxVolumeLevel = 6


    fun changeVolume() {
        if (currentVolumeLevel < maxVolumeLevel) {
            currentVolumeLevel++
        } else {
            currentVolumeLevel = 0
        }
        Log.e("changeVolume", "value: $currentVolumeLevel", )
        _changeVolume()
    }
    private fun _changeVolume() {
        audioManager.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            (30 * currentVolumeLevel / 10),
            0
        )
    }
    private fun chooseCurrentMusic(): Int {
        return when(currentMusicIndex){
            0f -> R.raw.first_song
            1f -> R.raw.second_song
            2f -> R.raw.third_song
            else -> R.raw.second_song
        }
    }

    fun startMediaPlayer(context: Context) {
        stopMediaPlayer()
        mediaPlayer = MediaPlayer.create(context, chooseCurrentMusic())
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }
    fun stopMediaPlayer() {
        mediaPlayer.stop()
    }


    init {
        _changeVolume()
    }
}