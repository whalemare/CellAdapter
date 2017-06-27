package ru.whalemare.celladapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.whalemare.celladapter.cell.Cell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
open class CellAdapter<V : Cell.ViewHolder, D>(val cell: Cell<V, D>,
                                               val list: MutableList<D> = arrayListOf())
    : RecyclerView.Adapter<V>() {

    override fun getItemCount(): Int {
        return list.size
    }

    open protected fun getItem(position: Int): D {
        return list[position]
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        cell.bind(holder, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return cell.viewHolder(parent, viewType)
    }

    //region api
    open fun addItems(items: List<D>) {
        val rangeStart = list.size
        list.addAll(items)
        notifyItemRangeChanged(rangeStart, items.size)
    }

    open fun setItems(items: List<D>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
    //endregion
    // check master build
    // new tag 13
}