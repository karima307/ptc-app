package android.ptc.com.ptcflixing.model.objects

import android.ptc.com.ptcflixing.model.objects.Metadata
import com.google.gson.annotations.SerializedName


data class SearchResponseModel(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("metadata") var metadata: Metadata? = Metadata()

)