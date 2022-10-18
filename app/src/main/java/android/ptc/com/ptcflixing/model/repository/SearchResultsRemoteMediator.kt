package android.ptc.com.ptcflixing.model.repository

import android.ptc.com.ptcflixing.helpers.Q
import android.ptc.com.ptcflixing.model.database.AppDatabase
import android.ptc.com.ptcflixing.model.database.dao.RemoteKeyDao
import android.ptc.com.ptcflixing.model.database.dao.SearchResultsDao
import android.ptc.com.ptcflixing.model.network.retrofit.ApiService
import android.ptc.com.ptcflixing.model.objects.RemoteKey
import android.ptc.com.ptcflixing.model.objects.SearchResultModel
import androidx.paging.*
import androidx.room.withTransaction
import okio.IOException
import retrofit2.HttpException

private const val STARTING_PAGE_INDEX = 1


@OptIn(ExperimentalPagingApi::class)
class SearchResultsRemoteMediator(
    private val apiService: ApiService,
    private val searchResultsDao: SearchResultsDao,
    private val remoteKeyDao: RemoteKeyDao,
    private val database: AppDatabase
) : RemoteMediator<Int, SearchResultModel>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, SearchResultModel>
    ): MediatorResult {
        var loadKey: Int = STARTING_PAGE_INDEX
        return try {
            loadKey = when (loadType) {
                LoadType.REFRESH -> {
                    searchResultsDao.deleteAll()
                    remoteKeyDao.deleteAll()
                    STARTING_PAGE_INDEX
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(true)
                }
                LoadType.APPEND -> {
                    val remoteKey = remoteKeyDao.get()!!

                    if (remoteKey.currentPage == remoteKey.lastPage) {
                        return MediatorResult.Success(true)
                    }

                    remoteKey.currentPage.plus(1)
                }
            }

            val response = apiService.getSearchResult(loadKey)

            database.withTransaction {
                remoteKeyDao.insertOrReplace(
                    RemoteKey(
                        currentPage = loadKey,
                        lastPage = -1
                    )
                )

                response?.metadata?.searchResultModels?.let { searchResultsDao.insertAll(it) }
            }

            MediatorResult.Success(false)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            when (e.code()) {
                404 -> {
                    database.withTransaction {
                        remoteKeyDao.insertOrReplace(
                            RemoteKey(
                                currentPage = loadKey.minus(1),
                                lastPage = loadKey.minus(1)
                            )
                        )
                    }

                    MediatorResult.Error(Exception(e.code().toString()))
                }
                else -> {
                    MediatorResult.Error(e)
                }
            }
        }
    }

    override suspend fun initialize(): InitializeAction {
        return if (Q.IS_CONNECTED) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }
}