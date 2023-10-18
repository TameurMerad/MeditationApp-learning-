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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composefirst.ui.theme.ComposeFirstTheme
import com.example.composefirst.ui.theme.values
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.time.format.TextStyle



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val textFieldState = remember{ mutableStateOf("") }
            val scaffoldStat = rememberScrollState()
            val scope = rememberCoroutineScope()
            val snackBarHostState = remember {SnackbarHostState()}
            val keyboardController = LocalSoftwareKeyboardController.current
            val scrollState = rememberScrollState()
            Scaffold (
                snackbarHost = { SnackbarHost(hostState = snackBarHostState)},
                modifier = Modifier.fillMaxSize()
            ){
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val context = LocalContext.current
                        ImageCard(myImageUrl = values.painter, title = values.title, modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                            secondImg = values.nigger
                        )
                    }

                    OutlinedTextField(
                        value = textFieldState.value,
                        onValueChange = {textFieldState.value = it},
                        label = {
                            Text(text = "write here")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(17.dp)
                    )
                    Box (

                        modifier= Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            keyboardController?.hide()
//                            Toast.makeText(applicationContext,"hello nigger ${textFieldState.value}",Toast.LENGTH_SHORT).show()
                            scope.launch {
                                val result = snackBarHostState.showSnackbar(
                                    "yasseur no9ch",
                                    withDismissAction = true,
                                    actionLabel = "retry",
                                    duration = SnackbarDuration.Indefinite
                                    )
                                when(result){
                                    SnackbarResult.Dismissed ->{
                                        Toast.makeText(applicationContext,"action dismissed",Toast.LENGTH_SHORT).show()
                                    }
                                    SnackbarResult.ActionPerformed ->{
                                        Toast.makeText(applicationContext,"action Performed",Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }

                        }){
                            Text(text = "click her nigger")
                        }
                    }
                    LazyColumn(){
                        val myList = mutableListOf<Int>()
                        for (i in 1..50){
                            myList.add(i)
                        }
                        itemsIndexed(myList){ index,item ->

                            Text(
                                text = "item $item",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )


                        }

                    }





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
                                if (imageUrlT3i.value == secondImg) {
                                    imageUrlT3i.value = myImageUrl
                                } else imageUrlT3i.value = secondImg
                                Toast
                                    .makeText(applicationContext, "clicked", Toast.LENGTH_SHORT)
                                    .show()
                            } catch (e: Exception) {
                                Toast
                                    .makeText(applicationContext, e.message, Toast.LENGTH_SHORT)
                                    .show()
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