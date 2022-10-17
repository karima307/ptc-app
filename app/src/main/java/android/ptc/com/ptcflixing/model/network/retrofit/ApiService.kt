package android.ptc.com.ptcflixing.model.network.retrofit

import android.ptc.com.ptcflixing.helpers.Q
import android.ptc.com.ptcflixing.model.objects.SearchResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(Q.GET_PHONE)
    suspend fun getSearchResult(@Path("page") page:Int): SearchResponseModel?

}