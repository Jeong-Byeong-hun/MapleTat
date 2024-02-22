package com.example.masearch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.masearch.ui.theme.MaSearchTheme
import com.example.masearch.util.Navigation
import com.example.masearch.view.equipment.EquipmentDialogView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate: ")
        installSplashScreen()
        setContent {
            MaSearchTheme {
                Navigation()
//                EquipmentDialogView()
            }
        }
    }
}



