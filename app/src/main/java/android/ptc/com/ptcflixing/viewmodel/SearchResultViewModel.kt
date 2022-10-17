package android.ptc.com.ptcflixing.viewmodel

import android.ptc.com.ptcflixing.model.data.SearchResultData
import android.ptc.com.ptcflixing.model.network.retrofit.ApiService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class SearchResultViewModel(
    apiService: ApiService,

    ):ViewModel() {
    val imagesList = Pager(PagingConfig(pageSize = 10)) {
        SearchResultData(apiService)
    }.flow.cachedIn(viewModelScope)
}