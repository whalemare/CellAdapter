package ru.whalemare.sample.cell

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.celladapter.cell.DelegateCell
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Animal

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class AnimalDelegateCell : DelegateCell<AnimalDelegateCell.ViewHolder, Animal>(R.layout.cell_animal) {
    override fun isViewType(item: Any): Boolean {
        return item is Animal
    }

    override fun viewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(makeView(parent))
    }

    override fun bind(holder: ViewHolder, item: Animal) {
        holder.textNameAnimal.text = item.name
    }

    class ViewHolder(view: View) : Cell.ViewHolder(view) {
        val textNameAnimal = view.findViewById(R.id.text_name_animal) as TextView
    }
}