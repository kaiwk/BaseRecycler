package io.github.kermit95.baserecycler;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kermit on 16/3/19.
 */
public class BaseViewHolder<M> extends RecyclerView.ViewHolder{

    private final SparseArray<View> mViews;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>(10);
    }

    public BaseViewHolder(ViewGroup parent, @LayoutRes int layoutId){
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        mViews = new SparseArray<>(10);
    }

    @NonNull
    protected  <T extends View>T findView(@IdRes int id){
        View view = mViews.get(id);
        if (view == null){
            view = itemView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }

    public void setData(M itemData){}

    protected Context getContext(){
        return itemView.getContext();
    }
}
