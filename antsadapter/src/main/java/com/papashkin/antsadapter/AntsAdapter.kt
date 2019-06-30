package com.papashkin.antsadapter

import android.support.annotation.LayoutRes
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Pavel Antoshkin
 * Realization of the base adapter for recycler view.
 * You no need to override all this methods in your adapter extended on this base adapter.
 * @see IAntsBaseAdapter
 * @See RecyclerView.Adapter
 * @see AntsViewHolder
 */
abstract class AntsAdapter<VH : AntsViewHolder> : RecyclerView.Adapter<VH>(), IAntsBaseAdapter<Any> {
    private val items: MutableList<Any> = mutableListOf()
    private var callback: AntsBaseCallback<Any>? = null

    override fun add(item: Any) {
        items += item
        notifyItemInserted(items.lastIndex)
    }

    override fun addAll(items: List<Any>) {
        if (items.isEmpty()) return

        val startPosition = this.items.lastIndex + 1
        for (item in items) {
            this.items += item
        }
        notifyItemRangeInserted(startPosition, items.size)
    }

    override fun addTo(position: Int, item: Any) {
        items.add(position, item)
        notifyItemChanged(position)
    }

    override fun remove(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun clear() {
        val removedSize = items.size
        items.clear()
        notifyItemRangeRemoved(0, removedSize)
    }

    override fun setCallback(callback: AntsBaseCallback<Any>) {
        this.callback = callback
    }

    override fun update(newItems: List<Any>) {
        if (callback != null) {
            callback!!.setLists(items, newItems)
            val diffResult = DiffUtil.calculateDiff(callback!!)
            clear()
            addAll(newItems)
            diffResult.dispatchUpdatesTo(this)
        } else {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun getList(): List<Any> = items

    override fun getItemCount(): Int = items.size

    protected fun inflate(parent: ViewGroup, @LayoutRes viewType: Int): View =
        LayoutInflater.from(parent.context).inflate(viewType, parent, false)

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position], position)
    }

}