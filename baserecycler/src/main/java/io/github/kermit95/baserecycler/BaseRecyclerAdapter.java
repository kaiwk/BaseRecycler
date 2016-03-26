package io.github.kermit95.baserecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kermit on 16/3/19.
 */
public abstract class BaseRecyclerAdapter<T extends ItemViewModel> extends RecyclerView.Adapter<BaseViewHolder>{

    private List<T>  mDataList;
    private Context mContext;

    public BaseRecyclerAdapter(@NonNull Context context){
        init(context, new ArrayList<T>());
    }

    public BaseRecyclerAdapter(@NonNull Context context, @NonNull T[] dataArray){
        init(context, Arrays.asList(dataArray));
    }

    public BaseRecyclerAdapter(@NonNull Context context, @NonNull List<T> dataList){
        init(context, dataList);
    }

    private void init(Context context, List<T> dataList){
        this.mDataList = dataList;
        this.mContext = context;
    }

    /**
     * Any write operation performed on the array should be synchronized on this lock.
     */
    private final Object mLock = new Object();

    /**
     * Refresh or not, default is true.
     */
    private boolean mNotifyDataChanged = true;

    public void setNotifyDataChanged(boolean notifyDataChanged){
        this.mNotifyDataChanged = notifyDataChanged;
    }

    public void add(@NonNull T data){
        synchronized (mLock) {
            mDataList.add(data);
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }

    public void addAll(@NonNull Collection<T> datas){
        if (!datas.isEmpty()) {
            synchronized (mLock) {
                mDataList.addAll(datas);
            }
            if (mNotifyDataChanged) notifyDataSetChanged();
        }
    }

    public void addAll(@NonNull T...datas){
        if (datas.length != 0){
            synchronized (mLock){
                Collections.addAll(mDataList, datas);
            }
            if (mNotifyDataChanged) notifyDataSetChanged();
        }
    }

    public void insert(@NonNull T data, int index){
        synchronized (mLock){
            mDataList.add(index, data);
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }

    public void remove(@NonNull T data){
        synchronized (mLock){
            mDataList.remove(data);
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }

    public void remove(int index){
        synchronized (mLock){
            mDataList.remove(index);
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }

    public void clear(){
        synchronized (mLock){
            mDataList.clear();
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }

    public void sort(@NonNull Comparator<T> comparator){
        synchronized (mLock){
            Collections.sort(mDataList, comparator);
        }
        if (mNotifyDataChanged) notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).getViewType();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OnCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    @NonNull
    protected abstract BaseViewHolder OnCreateViewHolder(ViewGroup prarent, int viewType);
}
