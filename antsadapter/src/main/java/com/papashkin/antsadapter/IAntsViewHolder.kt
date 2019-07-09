package com.papashkin.antsadapter

interface IAntsViewHolder<T: Any> {
    fun bind(item: T, position: Int)
}