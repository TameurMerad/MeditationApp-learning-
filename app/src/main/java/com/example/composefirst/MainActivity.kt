package com.example.composefirst

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.composefirst.ui.theme.ImageCard
import com.example.composefirst.ui.theme.MainScreen
import com.example.composefirst.ui.theme.meditation_app.CardScroll
import com.example.composefirst.ui.theme.meditation_app.Greetings
import com.example.composefirst.ui.theme.meditation_app.HomeScreen
import com.example.composefirst.ui.theme.values
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardScroll()
        }
    }













@Composable
fun zell (){

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())

    ){

        ImageCard(myImageUrl = values.nigger, title ="zella ta3i" , secondImg =values.nigger ,
            modifier = Modifier.padding(bottom = 10.dp))
        ImageCard(myImageUrl = values.nigger, title ="zella ta3i" , secondImg =values.nigger,
            modifier = Modifier.padding(bottom = 10.dp) )
        ImageCard(myImageUrl = values.nigger, title ="zella ta3i" , secondImg =values.nigger,
            modifier = Modifier.padding(bottom = 10.dp) )
        ImageCard(myImageUrl = values.nigger, title ="zella ta3i" , secondImg =values.nigger,
            modifier = Modifier.padding(bottom = 10.dp) )
        ImageCard(myImageUrl = values.nigger, title ="zella ta3i" , secondImg =values.nigger )

    }
}



}

