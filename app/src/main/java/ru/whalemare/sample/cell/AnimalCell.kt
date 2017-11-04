package ru.whalemare.sample.cell

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Animal

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class AnimalCell : Cell<AnimalCell.ViewHolder, Animal>(R.layout.cell_person) {

    override fun bind(holder: AnimalCell.ViewHolder, item: Animal) {
        holder.textName.text = item.name
    }

    override fun viewHolder(parent: ViewGroup): AnimalCell.ViewHolder {
        return ViewHolder(makeView(parent))
    }

    class ViewHolder(view: View) : Cell.ViewHolder(view) {
        val textName = view.findViewById(R.id.text_name) as TextView
    }


}