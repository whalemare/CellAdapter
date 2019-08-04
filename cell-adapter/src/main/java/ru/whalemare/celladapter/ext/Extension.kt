package ru.whalemare.celladapter.ext

import ru.whalemare.celladapter.cell.CellDelegate

/**
 * @since 2018
 * @author Anton Vlasov - whalemare
 */

/**
 * Proxy for [mutableListOf] with casting
 */
fun <T : CellDelegate<*>> cells(vararg elements: T): MutableList<CellDelegate<Any>> {
    return elements.toMutableList() as MutableList<CellDelegate<Any>>
}