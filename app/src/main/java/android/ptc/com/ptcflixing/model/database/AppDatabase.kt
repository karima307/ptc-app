package android.ptc.com.ptcflixing.model.database

import android.ptc.com.ptcflixing.model.database.dao.RemoteKeyDao
import androidx.room.Database
import androidx.room.RoomDatabase
import android.ptc.com.ptcflixing.model.database.dao.SearchResultsDao
import android.ptc.com.ptcflixing.model.objects.RemoteKey
import android.ptc.com.ptcflixing.model.objects.SearchResultModel

@Database(entities = [SearchResultModel::class,RemoteKey::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sarchResultsDao(): SearchResultsDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}