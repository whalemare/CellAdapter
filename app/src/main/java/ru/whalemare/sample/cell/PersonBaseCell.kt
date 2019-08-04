package ru.whalemare.sample.cell

import ru.whalemare.celladapter.cell.CellDelegate
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Person

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class PersonBaseCell : CellDelegate<Person>(R.layout.cell_person) {

    override fun isViewType(value: Any) = value is Person

    override fun bind(holder: ru.whalemare.celladapter.ViewHolder, item: Person) {
        holder.setText(R.id.text_name, item.name)
    }

}