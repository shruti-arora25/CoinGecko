package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class Ticker(
    @SerializedName("base")
    var base: String,
    @SerializedName("bid_ask_spread_percentage")
    var bidAskSpreadPercentage: Double,
    @SerializedName("coin_id")
    var coinId: String,
    @SerializedName("converted_last")
    var convertedLast: ConvertedLast,
    @SerializedName("converted_volume")
    var convertedVolume: ConvertedVolume,
    @SerializedName("is_anomaly")
    var isAnomaly: Boolean,
    @SerializedName("is_stale")
    var isStale: Boolean,
    @SerializedName("last")
    var last: Double,
    @SerializedName("last_fetch_at")
    var lastFetchAt: String,
    @SerializedName("last_traded_at")
    var lastTradedAt: String,
    @SerializedName("market")
    var market: Market,
    @SerializedName("target")
    var target: String,
    @SerializedName("target_coin_id")
    var targetCoinId: String,
    @SerializedName("timestamp")
    var timestamp: String,
    @SerializedName("token_info_url")
    var tokenInfoUrl: Any,
    @SerializedName("trade_url")
    var tradeUrl: String,
    @SerializedName("trust_score")
    var trustScore: String,
    @SerializedName("volume")
    var volume: Double
)