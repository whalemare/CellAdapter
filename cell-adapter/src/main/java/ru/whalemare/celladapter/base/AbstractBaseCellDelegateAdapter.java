package ru.whalemare.celladapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public abstract class AbstractBaseCellDelegateAdapter<T extends WrapperHolder, D extends CellDelegate<T>>
        extends RecyclerView.Adapter<BaseViewHolder<? super T>>
        implements CellDelegateAdapterInterface<T, D> {

    protected final BaseCellDelegateManager<T, D> cellDelegateManager = new BaseCellDelegateManager<>();
    protected final List<T> items = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        final T item = items.get(position);
        return cellDelegateManager.getDelegate(item).type();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<? super T> holder, int position) {
        final T item = items.get(position);
        cellDelegateManager.getDelegate(item).bind(holder, item);
    }

    @Override
    public BaseViewHolder<? super T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return cellDelegateManager.getDelegate(viewType).holder(parent);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void addCellDelegate(D delegate) {
        cellDelegateManager.addDelegate(delegate);
    }

    @Override
    public void setItems(Collection<T> items) {
        if (items == null) {
            return;
        }
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void addItems(Collection<T> items) {
        if (items == null) {
            return;
        }
        final int positionStart = this.items.size();
        final int itemCount = items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    @Override
    public void removeItem(T item) {
        if (item == null) {
            return;
        }
        if (this.items.remove(item)) {
            notifyDataSetChanged();
        }
    }

    @Override
    public void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }
}
