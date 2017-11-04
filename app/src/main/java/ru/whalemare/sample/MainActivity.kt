package ru.whalemare.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ru.whalemare.celladapter.DelegateCellAdapter
import ru.whalemare.celladapter.cell.Cell
import ru.whalemare.celladapter.cell.DelegateCell
import ru.whalemare.sample.`object`.Animal
import ru.whalemare.sample.`object`.Person
import ru.whalemare.sample.cell.AnimalDelegateCell
import ru.whalemare.sample.cell.PersonDelegateCell
import java.util.*

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById(R.id.recycler_view) as RecyclerView

        val persons = (0..3).map {
            Person("Person $it")
        }.toMutableList()

        val animals = (0..3).map {
            Animal("Animal $it")
        }.toList()

        val list = mutableListOf<Any>()
        list.addAll(persons)
        list.addAll(animals)
        Collections.shuffle(list)

        val listDelegates = listOf(AnimalDelegateCell(), PersonDelegateCell())

        val mAdapter = DelegateCellAdapter(listDelegates as List<DelegateCell<Cell.ViewHolder, Any>>, list)
        recycler.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
            )
        }

        findViewById(R.id.fab).setOnClickListener {
            mAdapter.addItems(listOf(
                    Person("Person added ${System.currentTimeMillis()}")
            ))
        }
    }
}




