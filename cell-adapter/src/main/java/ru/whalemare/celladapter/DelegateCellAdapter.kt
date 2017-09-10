package ru.whalemare.celladapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.celladapter.cell.DelegateCell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class DelegateCellAdapter(
        private val cells: List<DelegateCell<Cell.ViewHolder, Any>>,
        val items: MutableList<Any> = mutableListOf()
) : RecyclerView.Adapter<Cell.ViewHolder>() {

    override fun getItemId(position: Int): Long {
        return items[position].hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return cells.indexOfFirst { it.isViewType(items[position]) }
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

    private fun getDelegate(item: Any): DelegateCell<Cell.ViewHolder, Any> {
        return cells.first { it.isViewType(item) }
    }

    private fun getDelegate(viewType: Int): DelegateCell<Cell.ViewHolder, Any> {
        return cells[viewType]
    }

    //region api
    open fun addItems(list: List<Any>) {
        val rangeStart = items.size
        items.addAll(list)
        notifyItemRangeChanged(rangeStart, items.size)
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

class SimpleCallback<T>(
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