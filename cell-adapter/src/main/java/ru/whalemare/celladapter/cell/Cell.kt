package ru.whalemare.celladapter.cell

import android.view.ViewGroup

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
interface Cell<H, T> {
    fun viewHolder(parent: ViewGroup): H

    fun bind(holder: H, item: T)
}