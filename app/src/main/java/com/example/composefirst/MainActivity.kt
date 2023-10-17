package com.example.composefirst

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefirst.ui.theme.ComposeFirstTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(R.drawable.pic)
            val title = "this is so me"

            Column (Modifier.verticalScroll(rememberScrollState())){
                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    val context = LocalContext.current

                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .clickable {
                            Toast
                                .makeText(context, "nmi nmi nmi ", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                }


                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),horizontalArrangement = Arrangement.SpaceBetween){
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f).fillMaxWidth()
                        .padding(8.dp) )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp).fillMaxWidth() )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                }
                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                }
                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                }
                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                    ImageCard(painter = painter, title =title,modifier = Modifier
                        .weight(1f)
                        .padding(8.dp) )
                }


            }





        }
    }
}

@Composable
fun ImageCard(painter: Painter, title: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    )
    {
        Box(modifier = Modifier.height(200.dp))
        {
//            here is the image
            Image(
                painter = painter,
                contentDescription = "null",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

//            here is the gradient
            Box (modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ), startY = 400f
                    )
                )
            )

//             here is the text
            Box (modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),contentAlignment = Alignment.BottomStart)
            {
                Text(text = title,
                    style = androidx.compose.ui.text.TextStyle(color = Color.White,
                        fontSize = 16.sp))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardPreview(){
    ImageCard(painter = painterResource(id = R.drawable.pic), title ="hadi hia" )
}