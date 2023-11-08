package com.example.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvas.ui.theme.CanvasTheme
import com.example.canvas.ui.theme.Green
import com.example.canvas.ui.theme.LightGreen
import com.example.canvas.ui.theme.LightGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(15.dp)
                        ){
                            DrawCanvas()
                            General()
                        }
                        ProgressMeasure(1.5f)
                    }

                }
            }
        }
    }
}

@Composable
fun ProgressMeasure(position: Float){
    Column {
        Canvas(modifier = Modifier.padding(5.dp)
            .height(15.dp)
            .fillMaxWidth()){
            val measure = this.size.width / position
            drawRoundRect(
                color = LightGrey,
                size = Size(width = size.width, size.height / 2.5f),
                topLeft = Offset(0f, size.height / 3f),
                cornerRadius = CornerRadius(10f, 10f)
            )
            drawRoundRect(
                color = Green,
                size = Size(width = measure, size.height / 2.5f),
                topLeft = Offset(0f, size.height / 3f),
                cornerRadius = CornerRadius(10f, 10f)
            )

            drawCircle(
                color = Color(0xFF2E723F),
                radius = 15f,
                center = Offset(measure, size.height / 2f)
            )
        }
    }

}


@Composable
fun General(){
    Column {
        Row {
            Text(text = "General",modifier = Modifier.weight(1f), style = MaterialTheme.typography.titleMedium.copy(fontSize = 17.sp))
            Text(text = "1000", style = MaterialTheme.typography.headlineMedium.copy(fontSize = 14.sp))
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Icon(imageVector = Icons.Default.CheckCircle,modifier = Modifier.size(12.dp), tint = Green, contentDescription = "")
            Text(text = "Discharged", style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp), modifier = Modifier.weight(1f))
            Text(text = "800", style = MaterialTheme.typography.headlineMedium.copy(fontSize = 14.sp))
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Icon(imageVector = Icons.Default.CheckCircle,modifier = Modifier.size(12.dp), tint = LightGreen, contentDescription = "")
            Text(text = "UnDischarged", style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp), modifier = Modifier.weight(1f))
            Text(text = "800", style = MaterialTheme.typography.headlineMedium.copy(fontSize = 14.sp))
        }

    }
}

@Composable
fun DrawCanvas() {
    Box(modifier = Modifier.fillMaxWidth(0.4f)) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(.65f)
                .aspectRatio(1f),
        ) {
            drawArc(
                color = LightGrey,
                startAngle = 0f,
                sweepAngle = 360f,
                style = Stroke(17f),
                useCenter = false
            )
            drawArc(
                color = Green,
                startAngle = 270f,
                sweepAngle = 280f,
                style = Stroke(17f, cap = StrokeCap.Round),
                useCenter = false,
            )

        }

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(.45f)
                .aspectRatio(1f),
        ) {
            drawArc(
                color = LightGrey,
                startAngle = 0f,
                sweepAngle = 360f,
                style = Stroke(17f, cap = StrokeCap.Round),
                useCenter = false
            )
            drawArc(
                color = LightGreen,
                startAngle = 180f,
                sweepAngle = 90f,
                style = Stroke(17f, cap = StrokeCap.Round),
                useCenter = false
            )
        }
        
        Column(modifier = Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "80%", style = MaterialTheme.typography.titleMedium.copy(color = Green, fontSize = 20.sp),)
            Text(text = "20%", style = MaterialTheme.typography.titleMedium.copy(color = LightGreen, fontSize = 16.sp))
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanvasTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DrawCanvas()
        }
    }

}