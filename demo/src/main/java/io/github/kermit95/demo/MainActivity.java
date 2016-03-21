package io.github.kermit95.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.github.kermit95.demo.baserecycler.DemoActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list_muti_recycler);
        mListView.setAdapter(new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getApplicationContext().getResources().getStringArray(R.array.main)));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, DemoActivity.class));
                        break;
                }
            }
        });
    }

}
