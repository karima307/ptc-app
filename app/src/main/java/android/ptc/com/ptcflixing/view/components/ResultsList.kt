package android.ptc.com.ptcflixing.view.components

import android.ptc.com.ptcflixing.viewmodel.SearchResultViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun ResultsList(searchResultViewModel: SearchResultViewModel) {
    val resultsData = searchResultViewModel.searchResult.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(resultsData.itemCount) { index ->
                resultsData[index]?.let {
                    ResultItemList(result = it)
                }
            }
            renderLoading(resultsData.loadState)
            renderError(resultsData.loadState)
        }
    )
}
