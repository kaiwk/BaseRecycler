package io.github.kermit95.demo.baserecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.kermit95.baserecycler.ItemViewModel;
import io.github.kermit95.demo.Constant;
import io.github.kermit95.demo.R;
import io.github.kermit95.demo.baserecycler.model.Person;

/**
 * Created by kermit on 16/3/21.
 */
public class DemoActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ItemViewModel> personList = new ArrayList<>();
        for (int i = 0; i < Constant.datas.length; i++) {
            Person person = new Person();
            person.setName(Constant.datas[i]);
            personList.add(person);
        }

        mRecyclerView.setAdapter(new MyAdapter(this, personList));
    }
}
