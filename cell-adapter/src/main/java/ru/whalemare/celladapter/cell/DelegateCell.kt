package ru.whalemare.celladapter.cell

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
abstract class DelegateCell<V : Cell.ViewHolder, in D : Any>(protected val cell: Cell<V, D>) {

    /**
     * Called to determine the correspondences between the data-object and the cell
     */
    abstract fun isViewType(item: Any): Boolean

    open fun bind(holder: V, item: D) {
        cell.bind(holder, item)
    }

    open fun viewHolder(parent: ViewGroup): V {
        return cell.viewHolder(parent)
    }

    open protected fun makeView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(cell.layoutRes, parent, false)
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}