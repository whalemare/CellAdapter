package ru.whalemare.celladapter.cell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
interface Cell<T> {
//    fun viewHolder(parent: ViewGroup): H

    fun bind(item: T)
}