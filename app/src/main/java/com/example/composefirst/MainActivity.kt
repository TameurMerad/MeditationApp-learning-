package com.example.composefirst

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composefirst.ui.theme.ComposeFirstTheme
import java.time.format.TextStyle



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var painter = "https://i.pinimg.com/originals/5a/dd/33/5add3332302c9db5e9a6aeedfeb6b29b.jpg"
            var nigger = "https://images.unsplash.com/photo-1696960594920-1ca9a1f250bc?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=1972"
            val title = "this is so me"
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val context = LocalContext.current

                        ImageCard(myImageUrl = painter, title = title, modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                            secondImg = nigger
                        )
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current.applicationContext)
                                .data(painter)
                                .crossfade(true)
                                .build(),
                             contentDescription = "pic",
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                            )
                    }
                }
        }
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun ImageCard(myImageUrl:String, title: String, modifier: Modifier = Modifier,secondImg:String) {
        val imageUrlT3i = mutableStateOf(myImageUrl)
        Card(
            modifier = modifier.fillMaxWidth()
            ,
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)

        )
        {
            Box(modifier = Modifier.height(200.dp))
            {
//            here is the image
                AsyncImage(

                    contentDescription = "null",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .clickable {
                            try {
                                if (imageUrlT3i.value == secondImg){
                                    imageUrlT3i.value = myImageUrl
                                }else imageUrlT3i.value = secondImg


                                Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()

                            }catch (e:Exception){
                                Toast.makeText(applicationContext,e.message,Toast.LENGTH_SHORT).show()

                            }
                        },
                    model = ImageRequest.Builder(LocalContext.current.applicationContext)
                        .data(imageUrlT3i.value)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.nigga_man),
                    contentScale = ContentScale.Crop
                )


//            here is the gradient
                Box(
                    modifier = Modifier
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp), contentAlignment = Alignment.BottomStart
                )
                {
                    Text(
                        text = title,
                        style = androidx.compose.ui.text.TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }


}