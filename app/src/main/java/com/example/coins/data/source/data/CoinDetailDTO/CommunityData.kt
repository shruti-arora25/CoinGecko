package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class CommunityData(
    @SerializedName("facebook_likes")
    var facebookLikes: Any,
    @SerializedName("reddit_accounts_active_48h")
    var redditAccountsActive48h: Int,
    @SerializedName("reddit_average_comments_48h")
    var redditAverageComments48h: Int,
    @SerializedName("reddit_average_posts_48h")
    var redditAveragePosts48h: Int,
    @SerializedName("reddit_subscribers")
    var redditSubscribers: Int,
    @SerializedName("telegram_channel_user_count")
    var telegramChannelUserCount: Any,
    @SerializedName("twitter_followers")
    var twitterFollowers: Int
)