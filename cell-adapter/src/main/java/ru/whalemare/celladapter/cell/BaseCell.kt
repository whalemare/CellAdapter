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
abstract class BaseCell<V : BaseCell.ViewHolder, D>(@LayoutRes protected val layoutRes: Int) : Cell<V, D> {

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup, layoutRes: Int) :
                this(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))
    }

    protected fun makeView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
    }
}