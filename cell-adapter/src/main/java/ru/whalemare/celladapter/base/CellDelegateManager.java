package ru.whalemare.celladapter.base;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public interface CellDelegateManager<T extends WrapperHolder, D extends CellDelegate<T>> {

    void addDelegate(D delegate);

    void removeDelegate(D delegate);

    D getDelegate(T item);

    D getDelegate(int viewType);
}
