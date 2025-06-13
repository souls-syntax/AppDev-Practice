package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgrounFinal()
                }
            }
        }
    }
}

@Composable
fun IntroPart(name: String = "Aakarsh Kashyap",
              job: String = "System level developer",
              dob: String = "10-10-2010",
              modifier: Modifier = Modifier
    ) {
    Column(
        modifier = Modifier.padding(top=95.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.Top,
        //horizontalAlignment = AbsoluteAlignment.Right
    ) {
        Text(
            text = name,
            color = Color(0xFF9ECE6A),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = job,
            color = Color(0xFF9ECE6A)
        )
        Text(
            text = dob,
            color = Color(0xFF9ECE6A)
        )
    }
}

@Composable
fun ContentDescribe(content: String = stringResource(R.string.content1), modifier: Modifier= Modifier) {
    Text(
        text = content,
        modifier = Modifier.padding(5.dp),
        textAlign = TextAlign.Justify,
        color = Color(0xFFC0CAF5)
    )

}

@Composable
fun Skill(skill: String, modifier: Modifier = Modifier) {
    Text(
        text = skill,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFC0CAF5),
        modifier = Modifier.padding(start=32.dp)
    )

}

@Composable
fun CharImage(name: String = "Aakarsh Kashyap",
              job: String = "System level developer",
              dob: String = "10-10-2010",
              modifier: Modifier = Modifier
) {
   val image = painterResource(R.drawable.imageuser)
    Column(Modifier.padding(start = 5.dp)) {
        Row() {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 40.dp, start = 5.dp)
                    .weight(1f),
                contentScale = ContentScale.Crop,

                )
            Spacer(modifier = Modifier.width(8.dp))
            IntroPart(
                name = name,
                job = job,
                dob = dob,
            )
        }
        Text(text = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
            textAlign = TextAlign.Justify,
            color = Color(0xFF7AA2F7),
            modifier = Modifier.fillMaxWidth(1f)
        )
        ContentDescribe()
        Text(text = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
            textAlign = TextAlign.Justify,
            color = Color(0xFF7AA2F7),
            modifier = Modifier.fillMaxWidth(1f)
        )
        Text(
            text = "List of Skill That I possess",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Left,
            color = Color(0xFF7DCFFF)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Skill("> Kotlin")
        Skill("> Python")
        Skill("> Git")
        Skill("> C")
        Skill("> Bash Scripting")
        Skill("> Arch Linux")
        Skill("> CSS")
        Skill("> C++")
        Skill("> Jetpack Compose")
        Text(text = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
            textAlign = TextAlign.Justify,
            color = Color(0xFF7AA2F7),
            modifier = Modifier.fillMaxWidth(1f).padding(end = 0.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactInfo(R.drawable.icons8_reddit_24, "souls-syntax")
            Spacer(modifier = Modifier.width(8.dp))
            ContactInfo(R.drawable.icons8_github_24, "souls-syntax")
            Spacer(modifier = Modifier.width(8.dp))
            ContactInfo(R.drawable.icons8_gmail_24, "souls.syntax@gmail.com")

        }
    }
}

@Composable
fun ContactInfo(Icon: Int, contact: String) {
    val image = painterResource(id = Icon)
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = contact,
            color = Color(0xFFBB9AF7)
            )
    }
}


@Composable
fun BackgrounFinal(
    name: String = "Aakarsh Kashyap",
   job: String = "System level developer",
   dob: String = "10-10-2010",
   modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.bussinesbackground)
    Box(Modifier.fillMaxSize().background(color = Color(0xFF1A1B26))) {
        Image(
            painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            alpha = 0.4F,
            modifier = Modifier
                .fillMaxSize()
                .blur(116.dp)

        )
        CharImage(
            name = name,
            job = job,
            dob = dob
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BackgrounFinal()
    }
}