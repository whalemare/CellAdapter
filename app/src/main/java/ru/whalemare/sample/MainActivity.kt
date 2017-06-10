package ru.whalemare.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ru.whalemare.celladapter.CellAdapter
import ru.whalemare.sample.`object`.Person
import ru.whalemare.sample.cell.PersonCell

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById(R.id.recycler_view) as RecyclerView
        val list = (0..100).map { Person("Name $it") }.toMutableList()

        recycler.apply {
            adapter = CellAdapter(PersonCell(), list)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}

