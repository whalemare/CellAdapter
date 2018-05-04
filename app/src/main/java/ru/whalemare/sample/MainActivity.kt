package ru.whalemare.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import ru.whalemare.celladapter.CellAdapter
import ru.whalemare.celladapter.cell.BaseCell
import ru.whalemare.celladapter.cell.CellDelegate
import ru.whalemare.sample.`object`.Animal
import ru.whalemare.sample.`object`.Person
import ru.whalemare.sample.cell.AnimalBaseCell
import ru.whalemare.sample.cell.PersonBaseCell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.recycler_view)

        val persons = (0..15).map {
            Person("Person $it")
        }.toMutableList()

        val animals = (16..30).map {
            Animal("Animal $it")
        }.toList()

        val list = mutableListOf<Any>()
        list.addAll(persons)
        list.addAll(animals)

        val listDelegates = listOf(AnimalBaseCell(), PersonBaseCell()) as List<CellDelegate<BaseCell.ViewHolder, Any>>

//        val mAdapter = CellAdapterDelegate(listDelegates)
        val mAdapter = CellAdapter(PersonBaseCell())
        recycler.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            val button = CounterView(context)
            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            addItemDecoration(HeaderViewDecoration(button))
        }

        findViewById<View>(R.id.fab).setOnClickListener {
            mAdapter.addItems(listOf(
                Person("Person added ${System.currentTimeMillis()}")
            ))
        }
    }
}




