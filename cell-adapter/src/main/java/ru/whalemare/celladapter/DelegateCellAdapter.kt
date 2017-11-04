package ru.whalemare.celladapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.celladapter.cell.DelegateCell
import java.lang.reflect.ParameterizedType

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
open class DelegateCellAdapter(
        private val cells: List<DelegateCell<Cell.ViewHolder, Any>>,
        protected val items: MutableList<Any> = mutableListOf()
) : RecyclerView.Adapter<Cell.ViewHolder>() {

    override fun getItemId(position: Int): Long {
        return items[position].hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        val viewType = cells.indexOfFirst { it.isViewType(items[position]) }
        if (viewType < 0) {
            throw UnsupportedOperationException("You need pass delegate cell for class ${items[position].javaClass}" +
                    ", but exists only ${cells.map {
                        (it::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[1]
                    }}")
        }
        return viewType
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cell.ViewHolder {
        return getDelegate(viewType).viewHolder(parent)
    }

    override fun onBindViewHolder(holder: Cell.ViewHolder, position: Int) {
        val item = items[position]
        getDelegate(item).bind(holder, item)
    }

    protected open fun getDelegate(item: Any): DelegateCell<Cell.ViewHolder, Any> {
        return cells.first { it.isViewType(item) }
    }

    protected open fun getDelegate(viewType: Int): DelegateCell<Cell.ViewHolder, Any> {
        return cells[viewType]
    }

    //region api
    open fun addItem(element: Any) {
        items.add(element)
        notifyItemInserted(items.size)
    }

    open fun addItems(list: List<Any>) {
        val rangeStart = items.size
        items.addAll(list)
        notifyItemRangeInserted(rangeStart, list.size)
    }

    open fun setItems(list: List<Any>) {
        val diffUtils = DiffUtil.calculateDiff(SimpleCallback(items, list))
        diffUtils.dispatchUpdatesTo(this)

        items.clear()
        items.addAll(list)
    }

    open fun clear(list: List<Any>) {
        items.clear()
        notifyDataSetChanged()
    }
    //endregion
}

open class SimpleCallback<T>(
        private val oldList: List<T>,
        private val newList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Data.getId() is String
        return oldList[oldItemPosition]!! == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]!! == equals(newList[newItemPosition])
    }

}