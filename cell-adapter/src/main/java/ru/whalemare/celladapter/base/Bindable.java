package ru.whalemare.celladapter.base;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public interface Bindable<T extends WrapperHolder> {
    void bind(T item);
}
