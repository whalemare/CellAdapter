package ru.whalemare.sample.cell

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.whalemare.celladapter.cell.BaseCell
import ru.whalemare.celladapter.cell.CellDelegate
import ru.whalemare.sample.R
import ru.whalemare.sample.`object`.Person

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class PersonBaseCell : BaseCell<PersonBaseCell.ViewHolder, Person>(R.layout.cell_person),
        CellDelegate<PersonBaseCell.ViewHolder, Person> {

    override fun isViewType(item: Any) = item is Person

    override fun bind(holder: ViewHolder, item: Person) {
        holder.textName.text = item.name
    }

    override fun viewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(makeView(parent))
    }

    class ViewHolder(view: View) : BaseCell.ViewHolder(view) {
        val textName = view.findViewById(R.id.text_name) as TextView
    }

}