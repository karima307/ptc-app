package android.ptc.com.ptcflixing.model.data

import android.ptc.com.ptcflixing.model.network.retrofit.ApiService
import android.ptc.com.ptcflixing.model.objects.SearchResponseModel
import androidx.paging.PagingSource
import androidx.paging.PagingState

class SearchResultData(
    private val apiService: ApiService,
) : PagingSource<Int, Any>() {
    override fun getRefreshKey(state: PagingState<Int, Any>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Any> {
        val prevKey: Int?
        val nextKey: Int?
        var response: SearchResponseModel? = null
        val dataList: ArrayList<Any> = ArrayList()

        return try {
            val nextPageNumber = params.key ?: 1
            try {
                response = apiService.getSearchResult(nextPageNumber, 10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (response != null) { //data was received from network without any problems
                prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else null
                nextKey =
                    if (response.metadata!!.results.isNotEmpty() && response.metadata!!.results.size == 10) nextPageNumber + 1 else null
            } else { // get data from database
                prevKey = null
                nextKey = null
            }
             response?.metadata?.let { dataList.addAll(it.results) }

            LoadResult.Page(
                data = dataList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}