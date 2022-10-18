package android.ptc.com.ptcflixing.model.database.dao

import android.ptc.com.ptcflixing.model.objects.RemoteKey
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertOrReplace(remoteKey: RemoteKey)

    @Query("SELECT * FROM remote_key LIMIT 1")
    suspend fun get(): RemoteKey?

    @Query("DELETE FROM remote_key")
    suspend fun deleteAll(): Int
}