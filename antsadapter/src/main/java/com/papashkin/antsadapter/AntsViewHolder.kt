package com.papashkin.antsadapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Pavel Antoshkin
 * base class of ViewHolder based on [RecyclerView.ViewHolder]
 * @method 'bind' allows to bind data and view in selected position
 */
abstract class AntsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item : Any, position: Int)
}