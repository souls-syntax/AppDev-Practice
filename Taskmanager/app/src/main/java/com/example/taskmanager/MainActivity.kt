package com.example.taskmanager

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StatusTic(
                        status = stringResource(R.string.status),
                        complement = stringResource(R.string.complement),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StatusText(status: String, complement: String, modifier: Modifier = Modifier) {
    Column(
       // modifier = Modifier.fillMaxSize(),
       // verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = status,
            modifier = Modifier
                .padding(top = 24.dp, end = 8.dp),//fillMaxSize(), //   .align(alignment = Alignment.CenterHorizontally,),
            fontWeight = Bold,
            fontSize = 16.sp,
            //lineHeight = 700.sp,
            //textAlign = TextAlign.Center

        )
        Text(
            text = complement,
            fontSize = 16.sp,
            //textAlign = TextAlign.Center

        )
    }
}

@Composable
fun StatusTic(status: String, complement: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.None,

        )

        StatusText(
            status = status,
            complement = complement
        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        StatusTic("Android", "guk")
    }
}