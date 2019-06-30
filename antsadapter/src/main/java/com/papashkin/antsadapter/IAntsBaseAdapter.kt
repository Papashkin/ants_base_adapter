package com.papashkin.antsadapter

/**
 * @author Pavel Antoshkin
 * interface of [AntsAdapter]
 */
interface IAntsBaseAdapter<T : Any> {
    /**
     * @method allows to add item into current items list
     */
    fun add(item: T)

    /**
     * @method allows to add new items list into the end of existed one
     */
    fun addAll(items: List<T>)

    /**
     * @method allows to add item into position in current items list
     */
    fun addTo(position: Int = 0, item: T)

    /**
     * @method allows to delete item fro selected position of the items list
     */
    fun remove(position: Int)

    /**
     * @method return the current items list
     */
    fun getList(): List<T>

    /**
     * @method allows to initialize the special callback.
     * @see AntsBaseCallback
     */
    fun setCallback(callback: AntsBaseCallback<T>)

    /**
     * @method allows to update list from one existed old list into new one.
     * this method uses standard 'notifyDataSetChanged', or callback initialized before.
     * @see AntsBaseCallback
     */
    fun update(newItems: List<T>)

    /**
     * @method clears current items (after that list will be empty)
     */
    fun clear()
}