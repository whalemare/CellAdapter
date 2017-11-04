package ru.whalemare.sample.cell

import ru.whalemare.celladapter.cell.DelegateCell
import ru.whalemare.sample.`object`.Animal

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class AnimalDelegateCell : DelegateCell<AnimalCell.ViewHolder, Animal>(AnimalCell()) {

    override fun isViewType(item: Any): Boolean {
        return item is Animal
    }

}