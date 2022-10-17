package android.ptc.com.ptcflixing.model.data

import android.ptc.com.ptcflixing.model.network.retrofit.ApiService
import android.ptc.com.ptcflixing.model.objects.SearchResult
import android.ptc.com.ptcflixing.model.objects.SearchResponseModel
import androidx.compose.ui.res.stringResource
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException

class SearchResultData(
    private val apiService: ApiService,
) : PagingSource<Int, SearchResult>() {
    override fun getRefreshKey(state: PagingState<Int, SearchResult>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResult> {
        val prevKey: Int?
        val nextKey: Int?
        var response: SearchResponseModel? = null
        val dataList: ArrayList<SearchResult> = ArrayList()

        return try {
            val nextPageNumber = params.key ?: 1

            response = apiService.getSearchResult(nextPageNumber)

            if (response != null) { //data was received from network without any problems
                prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else null
                nextKey =
                    if (response.metadata!!.searchResults.isNotEmpty() && response.metadata!!.searchResults.size == 10) nextPageNumber + 1 else null
            } else { // get data from database
                prevKey = null
                nextKey = null
            }
             response?.metadata?.let {
                 dataList.addAll(it.searchResults)
             }

            LoadResult.Page(
                data = dataList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: HttpException) {
            e.printStackTrace()
            when(e.code()){
                404 -> {
                    LoadResult.Error(Exception(e.code().toString()))
                }
                else -> {
                    LoadResult.Error(e)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}