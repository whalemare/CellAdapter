package ru.whalemare.sample.cell

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.celladapter.cell.DelegateCell
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Person

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class PersonDelegateCell : DelegateCell<PersonDelegateCell.ViewHolder, Person>(R.layout.cell_person) {
    override fun isViewType(item: Any): Boolean {
        return item is Person
    }

    override fun viewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(makeView(parent))
    }

    override fun bind(holder: ViewHolder, item: Person) {
        holder.textName.text = item.name
    }

    inner class ViewHolder(view: View) : Cell.ViewHolder(view) {
        val textName = view.findViewById(R.id.text_name) as TextView
    }
}