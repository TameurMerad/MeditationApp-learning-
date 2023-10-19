package com.example.composefirst.ui.theme.meditation_app

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composefirst.R
import com.example.composefirst.ui.theme.theme.ButtonBlue
import com.example.composefirst.ui.theme.theme.DarkerButtonBlue
import com.example.composefirst.ui.theme.theme.LightRed
import com.example.composefirst.ui.theme.theme.TextWhite
import com.plcoding.meditationuiyoutube.ui.theme.gothicA1
import java.time.format.TextStyle

@Composable
fun Greetings ( name:String){

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {

            Text(text = "Good morning, $name",
                textAlign = TextAlign.Start,
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            Text(text = "We wish you have a good day!",
                color = TextWhite,
                fontFamily = gothicA1,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        }

        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(25.dp)
        )
    }
}




@Composable
fun ChipsSection(
    myList: MutableList<String>
){
    var selectedChip by remember{ mutableStateOf(0) }
    LazyRow(){
        itemsIndexed(myList){index, item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .clickable {
                        selectedChip = index
                    }
                    .background(
                        if (selectedChip == index) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
                ,
                contentAlignment = Alignment.Center,

            ){
                Text(
                    text = item,
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                    )


            }


        }
    }

}



@Composable
fun Thoughts (){

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding( 15.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(LightRed)
        .padding(start =  15.dp, end = 15.dp , top = 25.dp, bottom =25.dp)    ){
        Row (modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Daily Thoughts",
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                    )
                Text(
                    text = "Meditation * 3-10 min",
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier

                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(5.dp)
            ){
                Icon(painter = painterResource(R.drawable.ic_play), contentDescription ="play icon",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                    )
            }


        }




    }



}

