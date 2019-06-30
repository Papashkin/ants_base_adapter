package com.papashkin.antsadaptersample

import android.view.View
import android.view.ViewGroup
import com.papashkin.antsadapter.AntsAdapter
import com.papashkin.antsadapter.AntsViewHolder
import kotlinx.android.synthetic.main.card_user_info.view.*


class TestAdapter : AntsAdapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = inflate(parent, R.layout.card_user_info)
        return TestViewHolder(view)
    }
}

class TestViewHolder(view: View) : AntsViewHolder(view) {
    override fun bind(item: Any, position: Int) {
        with(item as UserModel) {
            itemView.tvUserName.text = ("${this.name} ${this.surname}, ${this.age} years old")
        }
    }
}