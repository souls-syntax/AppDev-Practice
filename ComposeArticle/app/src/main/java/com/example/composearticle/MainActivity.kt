package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleImage(
                        heading = stringResource(R.string.Heading),
                        firstPara = stringResource(R.string.firstPara),
                        secPara = stringResource(R.string.secPara),
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun ArticleText(heading: String, firstPara: String, secPara: String,  modifier: Modifier = Modifier) {
    Column {
        Text(
            text = heading,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = firstPara,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = secPara,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}

@Composable
fun ArticleImage(heading: String, firstPara: String, secPara: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(top = 5.dp),
            contentScale = ContentScale.Fit,
            )
        ArticleText(
            heading = heading,
            firstPara = firstPara,
            secPara = secPara
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleImage("Android", "Hell", "bby")
    }
}