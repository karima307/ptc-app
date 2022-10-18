package android.ptc.com.ptcflixing.viewmodel

import android.ptc.com.ptcflixing.model.repository.SearchResultsRepo
import androidx.lifecycle.ViewModel


class SearchResultViewModel(searchResultsRepo: SearchResultsRepo
    ):ViewModel() {
/*    val searchResult = Pager(PagingConfig(pageSize = 20)) {
        SearchResultData(apiService)
    }.flow.cachedIn(viewModelScope)*/

    val searchResult = searchResultsRepo.getResultsWithRemoteMediator()
}