package android.ptc.com.ptcflixing.koin

import android.ptc.com.ptcflixing.model.network.retrofit.RetrofitService
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single { RetrofitService.apiService }
}