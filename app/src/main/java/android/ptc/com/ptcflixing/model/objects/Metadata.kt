package android.ptc.com.ptcflixing.model.objects

 import com.google.gson.annotations.SerializedName


data class Metadata(

    @SerializedName("sort") var sort: String? = null,
    @SerializedName("total_products") var totalProducts: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("results") var searchResults: ArrayList<SearchResult> = arrayListOf()

)