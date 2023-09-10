package com.example.customshapebutton

import android.content.res.Resources.getSystem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customshapebutton.ui.theme.CustomShapeButtonTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomShapeButtonTheme {
                Content()
            }
        }
    }
}

private val Dp.float: Float get() = this.value * getSystem().displayMetrics.density

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = { },
            modifier = Modifier.size(width = 40.dp, height = 30.dp),
            shape = TriangleShape(4.dp.float),
            contentPadding = PaddingValues(4.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.dp)
        ) {
            Text(
                text = "+1",
                modifier = Modifier.offset(x = -(40.0 * 1 / 5).roundToInt().dp),
                fontSize = 8.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}
