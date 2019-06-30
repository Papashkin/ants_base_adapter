package com.papashkin.antsadaptersample

import com.papashkin.antsadapter.AntsBaseCallback

class TestCallback : AntsBaseCallback<UserModel>() {
    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        // compare two items here
        return false
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        // full comparing of items here
        return false
    }

}