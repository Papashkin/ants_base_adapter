package com.papashkin.antsadapter

import android.support.v7.util.DiffUtil

/**
 * @author Pavel Antoshkin
 * Realization of the DiffUtil callback
 * @see DiffUtil.Callback
 */
abstract class AntsBaseCallback<T : Any> : DiffUtil.Callback() {
    var oldList: List<T> = listOf()
    var newList: List<T> = listOf()

    fun setLists(oldList: List<T>, newList: List<T>) {
        this.oldList = oldList
        this.newList = newList
    }

    override fun getNewListSize(): Int = this.newList.size

    override fun getOldListSize(): Int = this.oldList.size
}