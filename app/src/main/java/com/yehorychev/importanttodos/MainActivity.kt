package com.yehorychev.importanttodos

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import com.yehorychev.importanttodos.ui.theme.ImportantTodosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.post {
            setupEdgeToEdge(window)
        }

        setContent {
            ImportantTodosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidView(
                        factory = { context ->
                            LayoutInflater.from(context).inflate(R.layout.fragment_todos, null)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun setupEdgeToEdge(window: Window) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = window.insetsController
            controller?.systemBarsBehavior =
                android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }
}