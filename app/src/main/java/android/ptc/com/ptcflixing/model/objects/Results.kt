package android.ptc.com.ptcflixing.model.objects

import com.google.gson.annotations.SerializedName


data class Results(

    @SerializedName("sku") var sku: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("max_saving_percentage") var maxSavingPercentage: Int? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("special_price") var specialPrice: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("rating_average") var ratingAverage: Int? = null

)