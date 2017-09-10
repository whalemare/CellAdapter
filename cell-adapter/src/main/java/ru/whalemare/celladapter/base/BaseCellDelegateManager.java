package ru.whalemare.celladapter.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public final class BaseCellDelegateManager<T extends WrapperHolder,
        D extends CellDelegate<T>>
        implements CellDelegateManager<T, D> {
    private final List<D> delegates = new ArrayList<>();

    @Override
    public void addDelegate(D delegate) {
        delegates.add(delegate);
    }

    @Override
    public void removeDelegate(D delegate) {
        delegates.remove(delegate);
    }

    @Override
    public D getDelegate(T item) {
        for (D delegate : delegates) {
            if (delegate.is(item)) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }

    @Override
    public D getDelegate(int viewType) {
        for (D delegate : delegates) {
            if (delegate.type() == viewType) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }
}
