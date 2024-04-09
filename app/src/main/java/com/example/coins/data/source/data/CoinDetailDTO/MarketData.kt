package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class MarketData(
    @SerializedName("ath")
    var ath: Ath,
    @SerializedName("ath_change_percentage")
    var athChangePercentage: AthChangePercentage,
    @SerializedName("ath_date")
    var athDate: AthDate,
    @SerializedName("atl")
    var atl: Atl,
    @SerializedName("atl_change_percentage")
    var atlChangePercentage: AtlChangePercentage,
    @SerializedName("atl_date")
    var atlDate: AtlDate,
    @SerializedName("circulating_supply")
    var circulatingSupply: Int,
    @SerializedName("current_price")
    var currentPrice: CurrentPrice,
    @SerializedName("fdv_to_tvl_ratio")
    var fdvToTvlRatio: Any,
    @SerializedName("fully_diluted_valuation")
    var fullyDilutedValuation: FullyDilutedValuation,
    @SerializedName("high_24h")
    var high24h: High24h,
    @SerializedName("last_updated")
    var lastUpdated: String,
    @SerializedName("low_24h")
    var low24h: Low24h,
    @SerializedName("market_cap")
    var marketCap: MarketCap,
    @SerializedName("market_cap_change_24h")
    var marketCapChange24h: Double,
    @SerializedName("market_cap_change_24h_in_currency")
    var marketCapChange24hInCurrency: MarketCapChange24hInCurrency,
    @SerializedName("market_cap_change_percentage_24h")
    var marketCapChangePercentage24h: Double,
    @SerializedName("market_cap_change_percentage_24h_in_currency")
    var marketCapChangePercentage24hInCurrency: MarketCapChangePercentage24hInCurrency,
    @SerializedName("market_cap_fdv_ratio")
    var marketCapFdvRatio: Double,
    @SerializedName("market_cap_rank")
    var marketCapRank: Int,
    @SerializedName("max_supply")
    var maxSupply: Int,
    @SerializedName("mcap_to_tvl_ratio")
    var mcapToTvlRatio: Any,
    @SerializedName("price_change_24h")
    var priceChange24h: Double,
    @SerializedName("price_change_24h_in_currency")
    var priceChange24hInCurrency: PriceChange24hInCurrency,
    @SerializedName("price_change_percentage_14d")
    var priceChangePercentage14d: Double,
    @SerializedName("price_change_percentage_14d_in_currency")
    var priceChangePercentage14dInCurrency: PriceChangePercentage14dInCurrency,
    @SerializedName("price_change_percentage_1h_in_currency")
    var priceChangePercentage1hInCurrency: PriceChangePercentage1hInCurrency,
    @SerializedName("price_change_percentage_1y")
    var priceChangePercentage1y: Double,
    @SerializedName("price_change_percentage_1y_in_currency")
    var priceChangePercentage1yInCurrency: PriceChangePercentage1yInCurrency,
    @SerializedName("price_change_percentage_200d")
    var priceChangePercentage200d: Double,
    @SerializedName("price_change_percentage_200d_in_currency")
    var priceChangePercentage200dInCurrency: PriceChangePercentage14dInCurrency,
    @SerializedName("price_change_percentage_24h")
    var priceChangePercentage24h: Double,
    @SerializedName("price_change_percentage_24h_in_currency")
    var priceChangePercentage24hInCurrency: PriceChangePercentage24hInCurrency,
    @SerializedName("price_change_percentage_30d")
    var priceChangePercentage30d: Double,
    @SerializedName("price_change_percentage_30d_in_currency")
    var priceChangePercentage30dInCurrency: PriceChangePercentage14dInCurrency,
    @SerializedName("price_change_percentage_60d")
    var priceChangePercentage60d: Double,
    @SerializedName("price_change_percentage_60d_in_currency")
    var priceChangePercentage60dInCurrency: PriceChangePercentage14dInCurrency,
    @SerializedName("price_change_percentage_7d")
    var priceChangePercentage7d: Double,
    @SerializedName("price_change_percentage_7d_in_currency")
    var priceChangePercentage7dInCurrency: PriceChangePercentage14dInCurrency,
    @SerializedName("roi")
    var roi: Any,
    @SerializedName("total_supply")
    var totalSupply: Int,
    @SerializedName("total_value_locked")
    var totalValueLocked: Any,
    @SerializedName("total_volume")
    var totalVolume: TotalVolume
)