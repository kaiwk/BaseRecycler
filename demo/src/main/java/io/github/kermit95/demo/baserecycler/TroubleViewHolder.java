package io.github.kermit95.demo.baserecycler;

import android.view.ViewGroup;
import android.widget.ImageView;

import io.github.kermit95.baserecycler.BaseViewHolder;
import io.github.kermit95.demo.R;
import io.github.kermit95.demo.baserecycler.model.Person;

/**
 * Created by kermit on 16/3/21.
 */
public class TroubleViewHolder extends BaseViewHolder<Person>{

    private ImageView mImageView;

    public TroubleViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_trouble);
        mImageView = findView(R.id.img_trouble);
    }

    @Override
    public void setData(Person itemData) {
        super.setData(itemData);
        mImageView.setImageResource(R.mipmap.ic_launcher);
    }
}
