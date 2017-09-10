package ru.whalemare.celladapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public abstract class BaseViewHolder<T extends WrapperHolder> extends RecyclerView.ViewHolder implements Bindable<T> {

    public BaseViewHolder(View itemView) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
    }
}
