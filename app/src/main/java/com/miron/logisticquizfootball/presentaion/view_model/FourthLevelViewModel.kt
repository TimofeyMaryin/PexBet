package com.miron.logisticquizfootball.presentaion.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miron.logisticquizfootball.data.CardIdModel

class FourthLevelViewModel : ViewModel() {


    var oldPosition by mutableStateOf(Pair<Int?, Int?>(null,null))


    val cardId = mutableListOf<MutableList<CardIdModel?>>(
        mutableListOf(CardIdModel(), CardIdModel()),
        mutableListOf(CardIdModel(), CardIdModel()),
        mutableListOf(CardIdModel(), CardIdModel()),
    )

    fun cleanGameZone() {
        cardId[0][0] = CardIdModel()
        cardId[0][1] = CardIdModel()

        cardId[1][0] = CardIdModel()
        cardId[1][1] = CardIdModel()

        cardId[2][0] = CardIdModel()
        cardId[2][1] = CardIdModel()
    }

    fun selectedCard(index: Pair<Int, Int>){
        Log.e("selectedCard", "oldPosition.second: ${oldPosition.second}; index.second: ${index.second}", )
        if (oldPosition.first == null && oldPosition.second == null) {
            Log.e("selectedCard", "1st condition is worked", )
            oldPosition = index
            cardId[oldPosition.first!!][oldPosition.second!!]?.isSelected = mutableStateOf(true)
            return
        }

        if (oldPosition.second == index.second) {
            Log.e("selectedCard", "2nd is worked", )
            cardId[oldPosition.first!!][oldPosition.second!!]?.isSelected = mutableStateOf(false)
            oldPosition = index
            cardId[oldPosition.first!!][oldPosition.second!!]?.isSelected = mutableStateOf(true)
            return
        }

        if (oldPosition.second != index.second) {
            Log.e("selectedCard", "3td condition is worked", )
            cardId[index.first][index.second]?.isSelected = mutableStateOf(true)
            cardId[index.first][index.second] = null
            cardId[oldPosition.first!!][oldPosition.second!!] = null

            oldPosition = Pair(null, null)

            return
        }
        if (cardId[index.first][index.second] == null) { Log.e("selectedCard", "4th condition is worked", ); return }

        Log.e("selectedCard", "WTF???", )

    }


}