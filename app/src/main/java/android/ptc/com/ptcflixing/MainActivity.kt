package android.ptc.com.ptcflixing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.activity.compose.setContent
import androidx.compose.material3.CenterAlignedTopAppBar

import androidx.compose.runtime.Composable
 import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            launchAppView()
        }
    }
    @Composable
    @Preview
    fun launchAppView(){

Text(text = "SplachScreen")
    }
}
