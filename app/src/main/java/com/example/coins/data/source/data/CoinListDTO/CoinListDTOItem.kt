package com.example.coins.data.source.data.CoinListDTO


import com.example.coins.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinListDTOItem(
    @SerializedName("ath")
    var ath: Double,
    @SerializedName("ath_change_percentage")
    var athChangePercentage: Double,
    @SerializedName("ath_date")
    var athDate: String,
    @SerializedName("atl")
    var atl: Double,
    @SerializedName("atl_change_percentage")
    var atlChangePercentage: Double,
    @SerializedName("atl_date")
    var atlDate: String,
    @SerializedName("circulating_supply")
    var circulatingSupply: Double,
    @SerializedName("current_price")
    var currentPrice: Double,
    @SerializedName("fully_diluted_valuation")
    var fullyDilutedValuation: Long,
    @SerializedName("high_24h")
    var high24h: Double,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("last_updated")
    var lastUpdated: String,
    @SerializedName("low_24h")
    var low24h: Double,
    @SerializedName("market_cap")
    var marketCap: Long,
    @SerializedName("market_cap_change_24h")
    var marketCapChange24h: Double,
    @SerializedName("market_cap_change_percentage_24h")
    var marketCapChangePercentage24h: Double,
    @SerializedName("market_cap_rank")
    var marketCapRank: Int,
    @SerializedName("max_supply")
    var maxSupply: Double,
    @SerializedName("name")
    var name: String,
    @SerializedName("price_change_24h")
    var priceChange24h: Double,
    @SerializedName("price_change_percentage_24h")
    var priceChangePercentage24h: Double,
    @SerializedName("roi")
    var roi: Roi,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("total_supply")
    var totalSupply: Double,
    @SerializedName("total_volume")
    var totalVolume: Long
)

{

    fun toCoin():Coin{
        return Coin(
            id,name,image,marketCap,currentPrice,priceChangePercentage24h,low24h,high24h
        )
    }


}