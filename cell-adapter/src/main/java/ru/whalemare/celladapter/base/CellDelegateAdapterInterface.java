package ru.whalemare.celladapter.base;

import java.util.Collection;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public interface CellDelegateAdapterInterface<T extends WrapperHolder, D extends CellDelegate<T>> {

    void addCellDelegate(D delegate);

    void setItems(Collection<T> items);

    void addItems(Collection<T> items);

    void removeItem(T item);

    T getItem(int position);

    void clear();
}
