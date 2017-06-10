package ru.whalemare.celladapter.cell

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
abstract class Cell<V : Cell.ViewHolder, in D>(@LayoutRes val layoutRes: Int) {

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup, layoutRes: Int) :
                this(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))
    }

    abstract fun bind(holder: V, item: D)

    abstract fun viewHolder(parent: ViewGroup, viewType: Int): V

    protected fun makeView(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
    }
}