package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class StackOverFlowUserBadgesResponse {
    @SerializedName("items")
    @Expose
    private var items: List<Item>? = null
    @SerializedName("has_more")
    @Expose
    private var hasMore: Boolean? = null
    @SerializedName("quota_max")
    @Expose
    private var quotaMax: Int? = null
    @SerializedName("quota_remaining")
    @Expose
    private var quotaRemaining: Int? = null

    fun getItems(): List<Item>? {
        return items
    }

    fun setItems(items: List<Item>) {
        this.items = items
    }

    fun getHasMore(): Boolean? {
        return hasMore
    }

    fun setHasMore(hasMore: Boolean?) {
        this.hasMore = hasMore
    }

    fun getQuotaMax(): Int? {
        return quotaMax
    }

    fun setQuotaMax(quotaMax: Int?) {
        this.quotaMax = quotaMax
    }

    fun getQuotaRemaining(): Int? {
        return quotaRemaining
    }

    fun setQuotaRemaining(quotaRemaining: Int?) {
        this.quotaRemaining = quotaRemaining
    }

    inner class User {
        @SerializedName("reputation")
        @Expose
        var reputation: Int? = null
        @SerializedName("user_id")
        @Expose
        var userId: Int? = null
        @SerializedName("user_type")
        @Expose
        var userType: String? = null
        @SerializedName("accept_rate")
        @Expose
        var acceptRate: Int? = null
        @SerializedName("profile_image")
        @Expose
        var profileImage: String? = null
        @SerializedName("display_name")
        @Expose
        var displayName: String? = null
        @SerializedName("link")
        @Expose
        var link: String? = null

    }

    inner class Item {
        @SerializedName("user")
        @Expose
        var user: User? = null
        @SerializedName("badge_type")
        @Expose
        var badgeType: String? = null
        @SerializedName("award_count")
        @Expose
        var awardCount: Int? = null
        @SerializedName("rank")
        @Expose
        var rank: String? = null
        @SerializedName("badge_id")
        @Expose
        var badgeId: Int? = null
        @SerializedName("link")
        @Expose
        var link: String? = null
        @SerializedName("name")
        @Expose
        var name: String? = null

    }
}