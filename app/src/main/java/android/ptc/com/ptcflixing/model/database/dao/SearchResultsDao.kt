package android.ptc.com.ptcflixing.model.database.dao

import android.ptc.com.ptcflixing.model.objects.SearchResultModel
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface SearchResultsDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(results: List<SearchResultModel>)

    @Query("DELETE FROM search_results")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM search_results")
    fun pagingSource(): PagingSource<Int, SearchResultModel>
}