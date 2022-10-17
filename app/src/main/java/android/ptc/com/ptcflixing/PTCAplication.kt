package android.ptc.com.ptcflixing

import android.app.Application
import android.ptc.com.ptcflixing.koin.appModule
import android.ptc.com.ptcflixing.koin.dbModule
import android.ptc.com.ptcflixing.koin.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class PTCAplication:Application() {

    companion object {
        lateinit var instance: PTCAplication
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            modules(getModules())
            androidContext(instance)
        }
    }

    private fun getModules(): List<Module> {
        return listOf(viewModel, appModule,dbModule)
    }
}