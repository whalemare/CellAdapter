package ru.whalemare.sample.cell

import ru.whalemare.celladapter.cell.DelegateCell
import ru.whalemare.sample.`object`.Person

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class PersonDelegateCell : DelegateCell<PersonCell.ViewHolder, Person>(PersonCell()) {

    override fun isViewType(item: Any): Boolean {
        return item is Person
    }

}