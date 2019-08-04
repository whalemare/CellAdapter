package ru.whalemare.sample.cell

import ru.whalemare.celladapter.cell.CellDelegate
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Animal

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class AnimalBaseCell : CellDelegate<Animal>(R.layout.cell_animal) {
    override fun isViewType(value: Any) = value is Animal

    override fun bind(holder: ru.whalemare.celladapter.ViewHolder, item: Animal) {
        holder.setText(R.id.text_name_animal, item.name)
    }

}