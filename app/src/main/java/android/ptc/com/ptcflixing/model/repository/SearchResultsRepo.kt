package android.ptc.com.ptcflixing.model.repository

import android.ptc.com.ptcflixing.model.database.dao.RemoteKeyDao
import android.ptc.com.ptcflixing.model.database.dao.SearchResultsDao
import android.ptc.com.ptcflixing.model.objects.SearchResultModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class SearchResultsRepo(
    private val searchResultsDao: SearchResultsDao,
    private val searchResultsRemoteMediator: SearchResultsRemoteMediator
) {


    fun getResultsWithRemoteMediator(): Flow<PagingData<SearchResultModel>> =
        Pager(
            PagingConfig(10),
            remoteMediator = searchResultsRemoteMediator) {
            searchResultsDao.pagingSource()
        }.flow


}

