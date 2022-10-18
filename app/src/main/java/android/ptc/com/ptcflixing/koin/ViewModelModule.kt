package android.ptc.com.ptcflixing.koin

import android.ptc.com.ptcflixing.viewmodel.SearchResultViewModel
import androidx.paging.ExperimentalPagingApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModel = module {
    viewModel {
      SearchResultViewModel(get())
     }
}