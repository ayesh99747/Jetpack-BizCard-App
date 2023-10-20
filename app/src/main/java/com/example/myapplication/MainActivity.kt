package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

// By adding the Composable annotation we are saying that this function is using the compose library.
@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    // We want to show some text
    // Text(text = "BizCard")
    // We can use the surface as a canvas.
    Surface(
        // We are saying that we want to take up the entire screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            // The card should have 200 pixels width and 390 pixels height.
            // The card should have a padding of 12 pixels.
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            // The card should have rounded corners.
            shape = RoundedCornerShape(15.dp),
            // The card should have a white background.
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            // The card should be elevated.
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                // The items should be aligned vertically from the top.
                verticalArrangement = Arrangement.Top,
                // The items should be centered horizontally.
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // This function is used to create the profile image widget.
                CreateImageProfile()
                // This divider separates the image from the information.
                Divider(thickness = 5.dp, color = Color.Blue)
                // This function is used to display the profile information.
                CreateInfo()
                // This button is used to display the portfolio lazy view.
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }
                ) {
                    // Label for the button.
                    Text(text = "Portfolio", style = MaterialTheme.typography.labelLarge)
                }
            }
            // If the button is clicked we show the portfolio otherwise it shows an empty box.
            if (buttonClickedState.value) {
                Content()
            } else {
                Box { }
            }

        }
    }
}

// This function is used to render the portfolio as a scrollable list.
@Composable
fun Portfolio(data: List<String>) {
    // Lazy column is like a recycler view. So it can be used to show lists of widgets.
    LazyColumn {
        items(data) { item ->
            // Each item will be enclosed in a card.
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
            ) {
                // In a card we get a row. The row has the profile image and the text.
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(7.dp)
                        .fillMaxWidth()
                ) {
                    // Calling the image profile function with a smaller image size.
                    CreateImageProfile(Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        // This text is what we pass in the list.
                        Text(item, fontWeight = FontWeight.Bold)
                        // This text is a static text applied to each item in the recycler view.
                        Text(text = "My Project", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

// This function represents the space for the scrollable list of projects.
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxHeight()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.Black)
        ) {
            // We are passing the projects as a list to the portfolio function.
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4",
                    "Project 5",
                    "Project 6",
                    "Project 7",
                    "Project 8",
                    "Project 9",
                    "Project 10"
                )
            )
        }
    }
}

// This function is used to display the profile info.
@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        // This Text widget represents the name.
        Text(
            text = "Miles P.",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Blue
        )
        // This Text widget represents the title.
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )
        // This Text widget represents the handle.
        Text(
            text = "@TheMilesCompose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

// This function is used to display the profile image.
@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    // We are using this surface for the profile image
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        // The image is stored in the res.drawable folder.
        Image(
            painter = painterResource(
                id = R.drawable.profile_image
            ),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CreateBizCard()
    }
}