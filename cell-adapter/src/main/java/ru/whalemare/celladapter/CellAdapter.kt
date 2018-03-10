package ru.whalemare.celladapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.whalemare.celladapter.cell.BaseCell
import ru.whalemare.celladapter.cell.Cell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
open class CellAdapter<V : BaseCell.ViewHolder, D>(val cell: Cell<V, D>,
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
        return cell.viewHolder(parent)
    }

    //region api
    open fun addItems(items: List<D>) {
        val rangeStart = list.size
        list.addAll(items)
        notifyItemRangeChanged(rangeStart, items.size)
    }

    open fun setItems(items: List<D>, animated: Boolean = false) {
        if (animated) {
            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return list[oldItemPosition]?.hashCode() == items[newItemPosition]?.hashCode()
                }

                override fun getOldListSize(): Int {
                    return list.size
                }

                override fun getNewListSize(): Int {
                    return items.size
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return list[oldItemPosition]?.hashCode() == items[newItemPosition]?.hashCode()
                }

            })
            result.dispatchUpdatesTo(this)
        }
        list.clear()
        list.addAll(items)

        if (!animated) {
            notifyDataSetChanged()
        }
    }

    open fun setItems(items: List<D>,
                      areItemsTheSame: (old: D, new: D) -> Boolean,
                      areContentsTheSame: (old: D, new: D) -> Boolean) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return areItemsTheSame.invoke(list[oldItemPosition], items[newItemPosition])
            }

            override fun getOldListSize(): Int {
                return list.size
            }

            override fun getNewListSize(): Int {
                return items.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return areContentsTheSame.invoke(list[oldItemPosition], items[newItemPosition])
            }

        })
        result.dispatchUpdatesTo(this)
        list.clear()
        list.addAll(items)
    }

    //endregion
}