package io.github.kermit95.demo.baserecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import io.github.kermit95.baserecycler.BaseRecyclerAdapter;
import io.github.kermit95.baserecycler.BaseViewHolder;
import io.github.kermit95.baserecycler.ItemViewModel;
import io.github.kermit95.demo.baserecycler.model.Person;

/**
 * Created by kermit on 16/3/21.
 */
public class MyAdapter extends BaseRecyclerAdapter<ItemViewModel>{


    public MyAdapter(@NonNull Context context) {
        super(context);
    }

    public MyAdapter(@NonNull Context context, @NonNull ItemViewModel[] dataArray) {
        super(context, dataArray);
    }

    public MyAdapter(@NonNull Context context, @NonNull List<ItemViewModel> dataList) {
        super(context, dataList);
    }

    @NonNull
    @Override
    protected BaseViewHolder OnCreateViewHolder(ViewGroup prarent, int viewType) {
        switch (viewType){
            case Person.SOME_THING_DIFFERENT: return new TroubleViewHolder(prarent);
            case Person.VIEW_TYPE: return new PersonViewHolder(prarent);
            default: throw new IllegalArgumentException("No matched view type!");
        }
    }
}
