package com.example.retrofitwithmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.model.StackOverFlowUserBadgesResponse
import com.example.retrofitwithmvvm.view_model.UserBadgeCountViewModel
import kotlinx.android.synthetic.main.activity_user_badge.*


const val USER_ID = "2949612"

class UserBadgeActivity : AppCompatActivity() {
    private lateinit var viewModel: UserBadgeCountViewModel
    private var bronze_count = 0
    private var silver_count = 0
    private var gold_count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.retrofitwithmvvm.R.layout.activity_user_badge)

        viewModel = ViewModelProvider(this).get(UserBadgeCountViewModel::class.java)
        viewModel.getUserBadgeDetails(USER_ID)
            .observe(this, object : Observer<StackOverFlowUserBadgesResponse> {
                override fun onChanged(userBadgeData: StackOverFlowUserBadgesResponse?) {
                    calculateBadges(userBadgeData!!)
                }

            })

    }

    private fun calculateBadges(userBadgeData: StackOverFlowUserBadgesResponse) {
        for (i in userBadgeData.getItems()!!.indices) {
            when (userBadgeData.getItems()!![i].rank) {
                "bronze" -> bronze_count += userBadgeData.getItems()!![i].awardCount!!
                "silver" -> silver_count += userBadgeData.getItems()!![i].awardCount!!
                "gold" -> gold_count += userBadgeData.getItems()!![i].awardCount!!
            }
        }
        tvBronzeBadge.text = "Bronze badge count $bronze_count"
        tvSilverBadge.text = "Silver badge count $silver_count"
        tvGoldBadge.text = "Gold badge count $gold_count"

    }

}
