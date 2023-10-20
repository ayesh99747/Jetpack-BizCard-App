package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun CreateBizCard(){
    // We want to show some text
    // Text(text = "BizCard")
    // We can use the surface as a canvas.
    Surface (
        // We are saying that we want to take up the entire screen.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card (
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
            Column (
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(thickness = 5.dp, color = Color.Blue)



            }

        }
    }
}

@Composable
private fun CreateImageProfile() {
    // We are using this surface for the profile image
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.profile_image
            ),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
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