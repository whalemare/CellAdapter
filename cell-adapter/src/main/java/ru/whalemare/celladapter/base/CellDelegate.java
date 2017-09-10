package ru.whalemare.celladapter.base;

import android.view.ViewGroup;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public interface CellDelegate<T extends WrapperHolder> {

    boolean is(T item);

    int type();

    BaseViewHolder<? super T> holder(ViewGroup parent);

    void bind(BaseViewHolder<? super T> holder, T item);

}
