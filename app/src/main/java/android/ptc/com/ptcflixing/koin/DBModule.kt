package android.ptc.com.ptcflixing.koin

import android.ptc.com.ptcflixing.model.database.AppDatabase
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val dbModule: Module = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "jumiadb")
        .fallbackToDestructiveMigration().build() }
    single { get<AppDatabase>().sarchResultsDao() }
    single { get<AppDatabase>().remoteKeyDao() }
}