package com.papashkin.antsadaptersample

import android.view.View
import android.view.ViewGroup
import com.papashkin.antsadapter.AntsAdapter
import com.papashkin.antsadapter.AntsViewHolder
import kotlinx.android.synthetic.main.card_user_info.view.*


class TestAdapter : AntsAdapter<TestViewHolder, UserModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = inflate(parent, R.layout.card_user_info)
        return TestViewHolder(view)
    }
}

class TestViewHolder(view: View) : AntsViewHolder<UserModel>(view) {
    override fun bind(item: UserModel, position: Int) {
        itemView.tvUserName.text = ("${item.name} ${item.surname}, ${item.age} years old")
    }
}