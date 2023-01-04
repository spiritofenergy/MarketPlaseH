package com.kodex.marketplase

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketPlaceTheme()
         }

    }

}

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MarketPlaceTheme() {
        val result = remember { mutableStateOf("") }
        val expanded = remember { mutableStateOf(false) }
        val liked = remember { mutableStateOf(true) }
        val context = LocalContext.current

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "BurgerMarket")
                    },

                    navigationIcon = {
                        // show drawer icon
                        IconButton(
                            onClick = {
                                result.value = "Drawer icon clicked"
                            }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = "")
                        }
                    },

                    actions = {
                        IconButton(onClick = {
                            result.value = " Share icon clicked"
                        }) {
                            Icon(Icons.Filled.Share, contentDescription = "")
                        }

                        IconToggleButton(
                            checked = liked.value,
                            onCheckedChange = {
                                liked.value = it
                                if (liked.value) {
                                    result.value = "Liked"
                                } else {
                                    result.value = "Unliked"
                                }
                            }
                        ) {
                            val tint by animateColorAsState(
                                if (liked.value) Color(0xFF7BB661)
                                else Color.LightGray
                            )
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Localized description",
                                tint = tint
                            )
                        }

                        Box(
                            Modifier
                                .wrapContentSize(Alignment.TopEnd)
                        ) {
                            IconButton(onClick = {
                                expanded.value = true
                                result.value = "More icon clicked"
                            }) {
                                Icon(
                                    Icons.Filled.MoreVert,
                                    contentDescription
                                    = "Localized description"
                                )
                            }

                            DropdownMenu(
                                expanded = expanded.value,
                                onDismissRequest = { expanded.value = false },
                            ) {
                                DropdownMenuItem(onClick = {
                                    expanded.value = false
                                    result.value = "First item clicked"
                                }) {
                                    Text("First Item")
                                }

                                DropdownMenuItem(onClick = {
                                    expanded.value = false
                                    result.value = "Second item clicked"
                                }) {
                                    Text("Second item")
                                }

                                Divider()

                                DropdownMenuItem(onClick = {
                                    expanded.value = false
                                    result.value = "Third item clicked"
                                }) {
                                    Text("Third item")
                                }

                                Divider()

                                DropdownMenuItem(onClick = {
                                    expanded.value = false
                                    result.value = "Fourth item clicked"
                                }) {
                                    Text("Fourth item")
                                }
                            }
                        }
                    },

                    backgroundColor = Color(0xFDCD7F32),
                    elevation = AppBarDefaults.TopAppBarElevation
                )
            },

            content = {
                Box(
                    Modifier
                        .background(Color(0XFFE3DAC9))
                        .padding(horizontal = 4.dp)
                        .fillMaxSize(),
                ) {
                    ShowFoodList(foodList)
                    Text(
                        text = result.value,
                        fontSize = 22.sp,
                        color = Color(0XFFE3DAC9),
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }

        )
    }

@Composable
fun ShowFoodList(foodList: List<Food>) {
    LazyColumn{
        items(foodList) {
            FoodCard(it,Modifier.padding(16.dp))
        }
    }
}


@Composable
fun FoodCard(food: Food, modifier: Modifier){
    Surface(shape = RoundedCornerShape(8.dp)
        , elevation = 8.dp, modifier = Modifier.padding(vertical = 2.dp)) {
        Column(modifier = Modifier
        .fillMaxWidth()) {
            Image(painter = painterResource(id = food.imgResource), contentDescription = "food",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = food.title, style = MaterialTheme
                    .typography.h5, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = food.desc, style = MaterialTheme
                    .typography.body1, modifier = Modifier.padding(bottom = 4.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    MarketPlaceTheme()

}


