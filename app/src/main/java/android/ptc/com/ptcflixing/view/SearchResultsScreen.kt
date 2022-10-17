package android.ptc.com.ptcflixing.view

import android.os.Bundle
import android.ptc.com.ptcflixing.view.theme.AppTheme
import android.ptc.com.ptcflixing.view.components.ResultsList
import android.ptc.com.ptcflixing.viewmodel.SearchResultViewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchResultsScreen : ComponentActivity() {
    private val searchResultViewModel: SearchResultViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ResultsList(searchResultViewModel = searchResultViewModel)
                }
            }
        }
    }
}
