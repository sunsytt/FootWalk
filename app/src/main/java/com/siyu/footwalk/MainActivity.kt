package com.siyu.footwalk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.siyu.footwalk.ui.navigation.AppNavGraph
import com.siyu.footwalk.ui.theme.FootWalkTheme
import android.graphics.Color as AndroidColor
import androidx.activity.SystemBarStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(AndroidColor.TRANSPARENT, AndroidColor.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(AndroidColor.TRANSPARENT, AndroidColor.TRANSPARENT),
        )
        val container = (application as FootWalkApp).container
        setContent {
            FootWalkTheme {
                AppNavGraph(authRepository = container.authRepository)
            }
        }
    }
}