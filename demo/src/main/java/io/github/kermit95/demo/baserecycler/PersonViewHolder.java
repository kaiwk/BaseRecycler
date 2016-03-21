package io.github.kermit95.demo.baserecycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.github.kermit95.baserecycler.BaseViewHolder;
import io.github.kermit95.demo.R;
import io.github.kermit95.demo.baserecycler.model.Person;

/**
 * Created by kermit on 16/3/21.
 */
public class PersonViewHolder extends BaseViewHolder<Person>{

    private TextView mTextView;
    private ImageView mImageView;

    public PersonViewHolder(ViewGroup parent){
        super(parent, R.layout.item_recycler);
        mTextView = findView(R.id.text);
        mImageView = findView(R.id.img);
    }

    @Override
    public void setData(Person itemData) {
        mTextView.setText(itemData.getName());
        mImageView.setImageResource(R.mipmap.ic_launcher);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getLayoutPosition() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
