package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("announcement_url")
    var announcementUrl: List<String>,
    @SerializedName("bitcointalk_thread_identifier")
    var bitcointalkThreadIdentifier: Any,
    @SerializedName("blockchain_site")
    var blockchainSite: List<String>,
    @SerializedName("chat_url")
    var chatUrl: List<String>,
    @SerializedName("facebook_username")
    var facebookUsername: String,
    @SerializedName("homepage")
    var homepage: List<String>,
    @SerializedName("official_forum_url")
    var officialForumUrl: List<String>,
    @SerializedName("repos_url")
    var reposUrl: ReposUrl,
    @SerializedName("subreddit_url")
    var subredditUrl: String,
    @SerializedName("telegram_channel_identifier")
    var telegramChannelIdentifier: String,
    @SerializedName("twitter_screen_name")
    var twitterScreenName: String,
    @SerializedName("whitepaper")
    var whitepaper: String
)