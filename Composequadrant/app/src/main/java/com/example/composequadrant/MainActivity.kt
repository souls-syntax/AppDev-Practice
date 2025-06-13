package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quad(
                        heading1 = stringResource(R.string.heading1) ,
                        content1 = stringResource(R.string.description1) ,
                        shade1 =0xFFEADDFF ,
                        heading2 = stringResource(R.string.heading2) ,
                        content2 = stringResource(R.string.description2) ,
                        shade2 = 0xFFD0BCFF,
                        heading3 = stringResource(R.string.heading3),
                        content3 = stringResource(R.string.description3) ,
                        shade3 = 0xFFB69DF8,
                        heading4 = stringResource(R.string.heading4),
                        content4 = stringResource(R.string.description4) ,
                        shade4 = 0xFFF6EDFF,
                    )
                }
            }
        }
    }
}

@Composable
fun TextQuad(heading: String,
             content: String,
             shade: Long,
             modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().background(color = Color(shade))

    ) {
        // Title Text
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 16.dp)
        )
        //Description Text
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun Quad(heading1: String,
         heading2: String,
         heading3: String,
         heading4: String,
         content1: String,
         content2: String,
         content3: String,
         content4: String,
         shade1: Long,
         shade2: Long,
         shade3: Long,
         shade4: Long,
         modifier: Modifier = Modifier
) {
    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxSize()//.padding(top= 25.dp)
    ) {
        Row(
            Modifier.weight(1f)) {
            TextQuad(
                heading = heading1,
                content = content1,
                shade = shade1,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 32.dp)
            )
            TextQuad(
                heading = heading2,
                content = content2,
                shade = shade2,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 32.dp)
            )
        }
        Row(Modifier.weight(1f)) {
            TextQuad(
                heading = heading3,
                content = content3,
                shade = shade3,
                modifier = Modifier.weight(1f)
            )
            TextQuad(
                heading = heading4,
                content = content4,
                shade = shade4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quad(
            heading1 =stringResource(R.string.heading1) ,
            content1 =stringResource(R.string.description1) ,
            shade1 =0xFFEADDFF ,
            heading2 =stringResource(R.string.heading2) ,
            content2 =stringResource(R.string.description2) ,
            shade2 = 0xFFD0BCFF,
            heading3 = stringResource(R.string.heading3),
            content3 =stringResource(R.string.description3) ,
            shade3 = 0xFFB69DF8,
            heading4 = stringResource(R.string.heading4),
            content4 =stringResource(R.string.description4) ,
            shade4 = 0xFFF6EDFF,
        )
    }
}