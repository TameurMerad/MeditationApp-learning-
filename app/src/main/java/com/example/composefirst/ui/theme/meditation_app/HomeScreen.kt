package com.example.composefirst.ui.theme.meditation_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefirst.R
import com.example.composefirst.ui.theme.theme.DeepBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(){
    val systemUiController = rememberSystemUiController()
    val chipList = mutableListOf("Soufyan","yassuer","yacine","Soufyan","yassuer","kach wahd")
    systemUiController.setStatusBarColor(DeepBlue)
    val btmList = listOf<BtmNavData>(
        BtmNavData(painterResource(R.drawable.ic_home),"Home" ),
        BtmNavData(painterResource(R.drawable.ic_bubble),"Meditate" ),
        BtmNavData(painterResource(R.drawable.ic_moon),"Sleep" ),
        BtmNavData(painterResource(R.drawable.ic_music),"Music" ),
        BtmNavData(painterResource(R.drawable.ic_profile),"Profile" )
    )


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 30.dp)

    ){
            Greetings(name = "Soufyan")
            ChipsSection(chipList)
            Thoughts()
            MySpacer(num = 0.01f)
            BigText(text = "Featured")
            CardScroll()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        DeepBlue
                    ), startY = 1500f
                )
            )
    )
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        BtmNavBar(btmList)
    }
    
}

