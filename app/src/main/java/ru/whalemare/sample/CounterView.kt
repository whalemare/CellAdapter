package ru.whalemare.sample

import android.content.Context
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.View

/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class CounterView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0)
    : LinearLayoutCompat(context, attributeSet, defStyle) {

    val mainView = View.inflate(context, R.layout.counter_view, this)


}