package com.example.composefirst.ui.theme.meditation_app

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composefirst.R
import com.example.composefirst.ui.theme.theme.AquaBlue
import com.example.composefirst.ui.theme.theme.Beige1
import com.example.composefirst.ui.theme.theme.BlueViolet1
import com.example.composefirst.ui.theme.theme.ButtonBlue
import com.example.composefirst.ui.theme.theme.DarkerButtonBlue
import com.example.composefirst.ui.theme.theme.DeepBlue
import com.example.composefirst.ui.theme.theme.LightGreen1
import com.example.composefirst.ui.theme.theme.LightRed
import com.example.composefirst.ui.theme.theme.OrangeYellow1
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
            modifier = Modifier
                .clickable {

                }
                .size(25.dp)

        )
    }
}



@Composable
fun ChipsSection(myList: MutableList<String>){
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
        .padding(15.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(LightRed)
        .padding(start = 15.dp, end = 15.dp, top = 25.dp, bottom = 25.dp)    ){
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
                    .clickable {

                    }
                    .background(ButtonBlue)
                    .padding(5.dp)

            ){
                Icon(
                    painter = painterResource(R.drawable.ic_play),
                    contentDescription ="play icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                    )
            }


        }




    }



}

@Composable
fun MySpacer(num: Float){
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(num))
}


@Composable
fun BigText (text:String){
    Text(text = text,
        color = TextWhite,
        fontFamily = gothicA1,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        textAlign = TextAlign.Start
        )

}



@SuppressLint("UnrememberedMutableState")
@Composable
fun SomethingCard( title: String, icon:Painter, BgColor:Color) {
    Card(
        modifier = Modifier
            .padding(8.dp)
//            .clickable {
//
//            }
            ,
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)

    )
    {


        Box(modifier = Modifier.height(200.dp))
        {



//             here is the text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BgColor)
                    .padding(22.dp)
                    , contentAlignment = Alignment.TopStart
            )
            {
                Text(
                    text = title,
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp
                    )
                )
            }


//            here is the button and the icon
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){

                Row (horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(15.dp)
                ) {


                    Box (contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(top = 10.dp)
                        ){
                        Icon(painter = icon, contentDescription = "myIcon",
                            modifier = Modifier
                                .size(24.dp),
                            tint = Color.White

                        )
                    }



                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .clickable {

                            }
                            .weight(0.5f)
                            .background(ButtonBlue)
                            .padding(15.dp)

                        ,
                        contentAlignment = Alignment.Center,
                    ){
                        Text(
                            text = "Start",
                            color = TextWhite,
                            fontFamily = gothicA1,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp
                        )


                    }



                }



            }
        }
    }
}



@Composable
fun CardScroll(){
    var verticalScrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScrollState)
            .padding(10.dp)
    ){
        Row (horizontalArrangement = Arrangement.SpaceBetween){

            Box(modifier = Modifier.weight(0.5f)){
                SomethingCard(title = "Listen to Music", icon = painterResource(R.drawable.ic_headphone) , BgColor = BlueViolet1)
            }
            Box(modifier = Modifier.weight(0.5f)){
                SomethingCard(title = "Watch Great Videos", icon = painterResource(R.drawable.ic_videocam) , BgColor = LightGreen1)
            }

        }
        Row (horizontalArrangement = Arrangement.SpaceBetween){

            Box(modifier = Modifier.weight(0.5f)){
                SomethingCard(title = "Calming Music", icon = painterResource(R.drawable.ic_music) , BgColor = Beige1)
            }
            Box(modifier = Modifier.weight(0.5f)){
                SomethingCard(title = "Night Island", icon = painterResource(R.drawable.ic_moon) , BgColor = OrangeYellow1)
            }

        }


    }



}



@Composable
fun BtmNavBar(
    itemList:List<BtmNavData>,
    modifier: Modifier=Modifier,
    activeHighlight :Color = ButtonBlue,
    activeText :Color = Color.White,
    inactiveText:Color= AquaBlue,
    inialSelectedItemIndex :Int = 0

){
    var selectedItemIndex by remember { mutableStateOf(inialSelectedItemIndex) }
    Row (
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ){
        itemList.forEachIndexed{index, btmNavData ->
                BtmNavBarItem(
                    item = btmNavData,
                    isSelcted = index == selectedItemIndex,
                    activeHighlight = activeHighlight,
                    activeText = activeText,
                    inactiveText = inactiveText

                ) {
                    selectedItemIndex = index
                }
        }





    }




}

@Composable
fun BtmNavBarItem(
        item:BtmNavData,
        isSelcted : Boolean=false,
        activeHighlight :Color = ButtonBlue,
        activeText :Color = Color.White,
        inactiveText:Color= AquaBlue,
        onItemClick:()-> Unit
)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(15.dp))
                .clickable {

                }
                .background(if (isSelcted) activeHighlight else Color.Transparent)
                .padding(5.dp)

        ){
            Icon(
                painter = item.Icon,
                contentDescription ="play icon",
                tint = if (isSelcted) activeText else inactiveText,
                modifier = Modifier
                    .size(16.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelcted)activeText else inactiveText
        )
        
    }



}

