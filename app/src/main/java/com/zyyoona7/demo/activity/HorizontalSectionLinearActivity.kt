package com.zyyoona7.demo.activity

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zyyoona7.demo.DataServer
import com.zyyoona7.demo.R
import com.zyyoona7.demo.adapter.HorizontalSectionAdapter
import com.zyyoona7.demo.dpToPx
import com.zyyoona7.itemdecoration.RecyclerViewDivider

class HorizontalSectionLinearActivity : BaseActivity() {

    override fun createLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun createAdapter(): RecyclerView.Adapter<BaseViewHolder> {
        return HorizontalSectionAdapter()
    }

    override fun addHeaderFooter(adapter: RecyclerView.Adapter<BaseViewHolder>) {
        val sectionAdapter = adapter as HorizontalSectionAdapter
        sectionAdapter.addHeaderView(getView(R.layout.item_hor_header))
        sectionAdapter.addFooterView(getView(R.layout.item_hor_footer))
    }

    override fun initItemDecoration(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<BaseViewHolder>) {
        val sectionAdapter = adapter as HorizontalSectionAdapter
        RecyclerViewDivider.linear()
            .color(Color.RED)
            .dividerSize(dpToPx(1f))
            .marginStart(dpToPx(20f))
            .hideDividerForItemType(BaseQuickAdapter.HEADER_VIEW)
            .hideAroundDividerForItemType(sectionAdapter.sectionItemType(), BaseQuickAdapter.FOOTER_VIEW)
            .build()
            .addTo(recyclerView)
    }

    override fun initData(adapter: RecyclerView.Adapter<BaseViewHolder>) {
        val sectionAdapter = adapter as HorizontalSectionAdapter
        sectionAdapter.setNewData(DataServer.createSectionLinearData(30))
    }

}
