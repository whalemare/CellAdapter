package ru.whalemare.celladapter.cell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
interface CellDelegate<H, T>: Cell<H, T> {

    /**
     * Called to determine the correspondences between the data-object and the cell
     */
    fun isViewType(item: Any): Boolean

}