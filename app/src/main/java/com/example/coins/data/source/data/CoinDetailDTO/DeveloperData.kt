package com.example.coins.data.source.data.CoinDetailDTO


import com.google.gson.annotations.SerializedName

data class DeveloperData(
    @SerializedName("closed_issues")
    var closedIssues: Int,
    @SerializedName("code_additions_deletions_4_weeks")
    var codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks,
    @SerializedName("commit_count_4_weeks")
    var commitCount4Weeks: Int,
    @SerializedName("forks")
    var forks: Int,
    @SerializedName("last_4_weeks_commit_activity_series")
    var last4WeeksCommitActivitySeries: List<Any>,
    @SerializedName("pull_request_contributors")
    var pullRequestContributors: Int,
    @SerializedName("pull_requests_merged")
    var pullRequestsMerged: Int,
    @SerializedName("stars")
    var stars: Int,
    @SerializedName("subscribers")
    var subscribers: Int,
    @SerializedName("total_issues")
    var totalIssues: Int
)