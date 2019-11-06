package com.example.retrofitwithmvvm.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpacingItemDecoration( verticalSpaceHeight:Int): RecyclerView.ItemDecoration() {
    private var verticalSpaceHeight: Int?=null

    init {
        this.verticalSpaceHeight = verticalSpaceHeight

    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeight!!
    }


}