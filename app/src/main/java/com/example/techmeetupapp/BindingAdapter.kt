package com.example.techmeetupapp

import android.view.Gravity.apply
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.techmeetupapp.network.GdgChapter
import com.example.techmeetupapp.search.GdgListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GdgChapter>?) {
    val adapter = recyclerView.adapter as GdgListAdapter
    adapter.submitList(data).
apply{
        // scroll the list to the top after the diffs are calculated and posted
        recyclerView.scrollToPosition(0)
    }

}

@BindingAdapter("showOnlyWhenEmpty")
fun View.showOnlyWhenEmpty(data: List<GdgChapter>?) {
    visibility = when {
        data == null || data.isEmpty() -> View.VISIBLE
        else -> View.GONE
    }
}
