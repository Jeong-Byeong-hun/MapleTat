package com.example.masearch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.masearch.mainui.LikeCharacterHolder
import com.example.masearch.mainui.PToolbarView
import com.example.masearch.mainui.previewLikeCharacter
import com.example.masearch.ui.theme.MaSearchTheme
import com.example.masearch.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var activity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate: ")
        activity = this

        setContent {
            MaSearchTheme {
                Navigation(viewModel)
//                LikeCharacterHolder(10)
//                previewLikeCharacter()
//                PToolbarView()

            }
        }

    }
}



