package com.qantas.test.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.qantas.test.helper.const.DatabaseConst

/**
 * model class for qantas airports
 */

@Entity(tableName = DatabaseConst.QANTAS_TABLE)
data class QantasData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("airportName") var airportName: String? = null,
    @SerializedName("city") var city: City? = City(),
    @SerializedName("country") var country: Country? = Country()
)

data class City(
    @SerializedName("cityName") var cityName: String? = null,
    @SerializedName("timeZoneName") var timeZoneName: String? = null
)

data class Country(

    @SerializedName("countryCode") var countryCode: String? = null,
    @SerializedName("countryName") var countryName: String? = null

)
