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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quad(
                        heading1 ="Text composable" ,
                        content1 ="Displays text and follows the recommended Material Design guidelines." ,
                        shade1 =0xFFEADDFF ,
                        heading2 ="Image composable" ,
                        content2 ="Creates a composable that lays out and draws a given Painter class object." ,
                        shade2 = 0xFFD0BCFF,
                        heading3 = "Row composable",
                        content3 ="A layout composable that places its children in a horizontal sequence." ,
                        shade3 = 0xFFB69DF8,
                        heading4 = "Column composable",
                        content4 ="A layout composable that places its children in a vertical sequence." ,
                        shade4 = 0xFFF6EDFF,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextQuad(heading: String, content: String, shade: Long, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color(shade))
    ) {
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(top= 25.dp)
    ) {
        Row(
            Modifier.weight(1f)) {
            TextQuad(
                heading = heading1,
                content = content1,
                shade = shade1,
                //modifier = Modifier.weight(0.5f)
            )
            TextQuad(
                heading = heading2,
                content = content2,
                shade = shade2,
            )
        }
        Row(Modifier.weight(0.5f)) {
            TextQuad(
                heading = heading3,
                content = content3,
                shade = shade3,
                //modifier = Modifier.weight(0.5f)
            )
            TextQuad(
                heading = heading4,
                content = content4,
                shade = shade4,
                //modifier = Modifier.weight(0.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quad(
            heading1 ="Text composable" ,
            content1 ="Displays text and follows the recommended Material Design guidelines." ,
            shade1 =0xFFEADDFF ,
            heading2 ="Image composable" ,
            content2 ="Creates a composable that lays out and draws a given Painter class object." ,
            shade2 = 0xFFD0BCFF,
            heading3 = "Row composable",
            content3 ="A layout composable that places its children in a horizontal sequence." ,
            shade3 = 0xFFB69DF8,
            heading4 = "Column composable",
            content4 ="A layout composable that places its children in a vertical sequence." ,
            shade4 = 0xFFF6EDFF,
        )
    }
}