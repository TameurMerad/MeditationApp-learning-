package com.example.composefirst.ui.theme.meditation_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composefirst.ui.theme.theme.DeepBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(){

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(DeepBlue)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 30.dp)

    ){
            Greetings(name = "Soufyan")
            ChipsSection(myList = mutableListOf("Soufyan","yassuer","kach wahd","Soufyan","yassuer","kach wahd"))

    }
}