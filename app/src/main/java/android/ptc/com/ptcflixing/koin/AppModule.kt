package android.ptc.com.ptcflixing.koin

import android.ptc.com.ptcflixing.model.network.retrofit.RetrofitService
import android.ptc.com.ptcflixing.model.repository.SearchResultsRemoteMediator
import android.ptc.com.ptcflixing.model.repository.SearchResultsRepo
import org.koin.core.module.Module
import org.koin.dsl.module


val appModule: Module = module {
    single { RetrofitService.apiService }
    single { SearchResultsRemoteMediator(get(),get(),get(),get()) }
    single { SearchResultsRepo(get(),get()) }
}