package ru.whalemare.celladapter.base;

import android.view.View;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public interface OnCellDelegateClickListener<T> {
    void onCellDelegateClick(View itemView, int position, T item);
}
