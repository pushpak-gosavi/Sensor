package com.pushpak.sensor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pushpak.sensor.ui.theme.SensorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val isDark = viewModel.isdark
            SensorTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = if (isDark) Color.DarkGray else Color.White),
                    contentAlignment = Alignment.Center){
                    Text(
                        text = if (isDark) {
                            "It's Dark out Side"
                        }else "It's Light out side",

                        color = if (isDark) Color.White else Color.DarkGray
                    )
                }
            }
        }
    }
}
