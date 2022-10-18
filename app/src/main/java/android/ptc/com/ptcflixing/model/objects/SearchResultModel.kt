package android.ptc.com.ptcflixing.model.objects

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "search_results")
data class SearchResultModel(

    @PrimaryKey
    @SerializedName("sku") var sku: String = "",
    @SerializedName("name") var name: String? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("max_saving_percentage") var maxSavingPercentage: Int? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("special_price") var specialPrice: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("rating_average") var ratingAverage: Int? = null

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchResultModel

        if (sku != other.sku) return false

        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}