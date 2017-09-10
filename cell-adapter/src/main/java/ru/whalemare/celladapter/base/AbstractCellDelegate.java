package ru.whalemare.celladapter.base;

/**
 * Developed 2017.
 *
 * @author Valentin S.Bolkonsky
 */

public abstract class AbstractCellDelegate<T extends WrapperHolder> implements CellDelegate<T> {

    @Override
    public void bind(BaseViewHolder<? super T> holder, T item) {
        holder.bind(item);
    }
}
