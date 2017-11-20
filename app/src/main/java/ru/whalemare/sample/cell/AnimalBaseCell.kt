package ru.whalemare.sample.cell

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.whalemare.celladapter.cell.BaseCell
import ru.whalemare.celladapter.cell.CellDelegate
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Animal

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class AnimalBaseCell : BaseCell<AnimalBaseCell.ViewHolder, Animal>(R.layout.cell_person),
        CellDelegate<AnimalBaseCell.ViewHolder, Animal> {
    override fun isViewType(item: Any) = item is Animal

    override fun bind(holder: AnimalBaseCell.ViewHolder, item: Animal) {
        holder.textName.text = item.name
    }

    override fun viewHolder(parent: ViewGroup): AnimalBaseCell.ViewHolder {
        return ViewHolder(makeView(parent))
    }

    class ViewHolder(view: View) : BaseCell.ViewHolder(view) {
        val textName = view.findViewById(R.id.text_name) as TextView
    }

}