package com.example.coins.data.source.data.CoinDetailDTO


import com.example.coins.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDTO(
    @SerializedName("additional_notices")
    var additionalNotices: List<Any>,
    @SerializedName("asset_platform_id")
    var assetPlatformId: Any,
    @SerializedName("block_time_in_minutes")
    var blockTimeInMinutes: Int,
    @SerializedName("categories")
    var categories: List<String>,
    @SerializedName("community_data")
    var communityData: CommunityData,
    @SerializedName("country_origin")
    var countryOrigin: String,
    @SerializedName("description")
    var description: Description,
    @SerializedName("detail_platforms")
    var detailPlatforms: DetailPlatforms,
    @SerializedName("developer_data")
    var developerData: DeveloperData,
    @SerializedName("genesis_date")
    var genesisDate: String,
    @SerializedName("hashing_algorithm")
    var hashingAlgorithm: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: Image,
    @SerializedName("last_updated")
    var lastUpdated: String,
    @SerializedName("links")
    var links: Links,
    @SerializedName("localization")
    var localization: Localization,
    @SerializedName("market_cap_rank")
    var marketCapRank: Int,
    @SerializedName("market_data")
    var marketData: MarketData,
    @SerializedName("name")
    var name: String,
    @SerializedName("platforms")
    var platforms: Platforms,
    @SerializedName("preview_listing")
    var previewListing: Boolean,
    @SerializedName("public_notice")
    var publicNotice: Any,
    @SerializedName("sentiment_votes_down_percentage")
    var sentimentVotesDownPercentage: Double,
    @SerializedName("sentiment_votes_up_percentage")
    var sentimentVotesUpPercentage: Double,
    @SerializedName("status_updates")
    var statusUpdates: List<Any>,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("tickers")
    var tickers: List<Ticker>,
    @SerializedName("watchlist_portfolio_users")
    var watchlistPortfolioUsers: Int,
    @SerializedName("web_slug")
    var webSlug: String
) {

    fun toCoinDetail(): CoinDetail {

        return CoinDetail(
            name, image.large, marketData.marketCap.usd.toDouble(),
            marketData.currentPrice.usd.toDouble(),
            marketData.marketCapChangePercentage24hInCurrency.usd,
            marketData.low24h.usd.toDouble(),
            marketData.high24h.usd.toDouble(),
            description.en)
    }


}