package ru.whalemare.sample

import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


/**
 * @since 2017
 * @author Anton Vlasov - whalemare
 */
class HeaderViewDecoration(private val header: View) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = getHeader(parent).measuredHeight
        }
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val childCount = parent.childCount
        if (childCount >= 0) {
            val child = parent.getChildAt(0)
            val adapterPos = parent.getChildAdapterPosition(child)

            if (adapterPos != RecyclerView.NO_POSITION) {
                canvas.save()

                val left = child.left.toFloat()
                val top = (child.y.toInt() - header.height).toFloat()
                canvas.translate(left, top)

                getHeader(parent).translationX = left
                getHeader(parent).translationY = top
                getHeader(parent).draw(canvas)

                canvas.restore()
            }
        }
    }

    private fun getHeader(parent: RecyclerView): View {
        if (header.measuredHeight > 0 || header.measuredWidth > 0) {
            // header already measured
        } else {
            val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.measuredWidth, View
                    .MeasureSpec.EXACTLY)
            val heightSpec = View.MeasureSpec.makeMeasureSpec(parent.measuredHeight, View
                    .MeasureSpec.UNSPECIFIED)

            val childWidth = ViewGroup.getChildMeasureSpec(widthSpec,
                    parent.paddingLeft + parent.paddingRight, header.layoutParams
                    .width)
            val childHeight = ViewGroup.getChildMeasureSpec(heightSpec,
                    parent.paddingTop + parent.paddingBottom, header.layoutParams
                    .height)

            header.measure(childWidth, childHeight)
            header.layout(0, 0, header.measuredWidth, header.measuredHeight)
        }

        return header
    }

}